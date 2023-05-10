<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="软件委托测试合同ID" prop="table4Id">
        <el-input v-model="queryParams.table4Id" placeholder="请输入软件委托测试合同ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="软件项目委托测试保密协议ID" prop="table5Id">
        <el-input v-model="queryParams.table5Id" placeholder="请输入软件项目委托测试保密协议ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="客户审核合同意见" prop="clientRemark">
        <el-input v-model="queryParams.clientRemark" placeholder="请输入客户审核合同意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市场部人员审核合同意见" prop="staffRemark">
        <el-input v-model="queryParams.staffRemark" placeholder="请输入市场部人员审核合同意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="实体合同材料url" prop="url">
        <el-input v-model="queryParams.url" placeholder="请输入实体合同材料url" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作工具栏 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                   v-hasPermi="['system:contract:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:contract:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="合同编号" align="center" prop="id" />
      <el-table-column label="软件委托测试合同ID" align="center" prop="table4Id" />
      <el-table-column label="软件项目委托测试保密协议ID" align="center" prop="table5Id" />
      <el-table-column label="客户审核合同意见" align="center" prop="clientRemark" />
      <el-table-column label="市场部人员审核合同意见" align="center" prop="staffRemark" />
      <el-table-column label="实体合同材料url" align="center" prop="url" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:contract:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:contract:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="软件委托测试合同ID" prop="table4Id">
          <el-input v-model="form.table4Id" placeholder="请输入软件委托测试合同ID" />
        </el-form-item>
        <el-form-item label="软件项目委托测试保密协议ID" prop="table5Id">
          <el-input v-model="form.table5Id" placeholder="请输入软件项目委托测试保密协议ID" />
        </el-form-item>
        <el-form-item label="客户审核合同意见" prop="clientRemark">
          <el-input v-model="form.clientRemark" placeholder="请输入客户审核合同意见" />
        </el-form-item>
        <el-form-item label="市场部人员审核合同意见" prop="staffRemark">
          <el-input v-model="form.staffRemark" placeholder="请输入市场部人员审核合同意见" />
        </el-form-item>
        <el-form-item label="实体合同材料url" prop="url">
          <el-input v-model="form.url" placeholder="请输入实体合同材料url" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { createContract, updateContract, deleteContract, getContract, getContractPage, exportContractExcel } from "@/api/system/contract";

export default {
  name: "Contract",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合同列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        table4Id: null,
        table5Id: null,
        clientRemark: null,
        staffRemark: null,
        url: null,
        createTime: [],
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询列表 */
    getList() {
      this.loading = true;
      // 执行查询
      getContractPage(this.queryParams).then(response => {
        this.list = response.data.list;
        this.total = response.data.total;
        this.loading = false;
      });
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 表单重置 */
    reset() {
      this.form = {
        id: undefined,
        table4Id: undefined,
        table5Id: undefined,
        clientRemark: undefined,
        staffRemark: undefined,
        url: undefined,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNo = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加合同";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getContract(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改合同";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }
        // 修改的提交
        if (this.form.id != null) {
          updateContract(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createContract(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除合同编号为"' + id + '"的数据项?').then(function() {
          return deleteContract(id);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      // 处理查询参数
      let params = {...this.queryParams};
      params.pageNo = undefined;
      params.pageSize = undefined;
      this.$modal.confirm('是否确认导出所有合同数据项?').then(() => {
          this.exportLoading = true;
          return exportContractExcel(params);
        }).then(response => {
          this.$download.excel(response, '合同.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
