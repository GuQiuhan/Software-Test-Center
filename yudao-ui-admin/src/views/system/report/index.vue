<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="软件测试报告ID" prop="table7Id">
        <el-input v-model="queryParams.table7Id" placeholder="请输入软件测试报告ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试用例（电子记录）ID" prop="table8Id">
        <el-input v-model="queryParams.table8Id" placeholder="请输入测试用例（电子记录）ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="软件测试记录(电子记录)ID" prop="table9Id">
        <el-input v-model="queryParams.table9Id" placeholder="请输入软件测试记录(电子记录)ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="软件测试问题清单（电子记录）ID" prop="table11Id">
        <el-input v-model="queryParams.table11Id" placeholder="请输入软件测试问题清单（电子记录）ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试部主管id" prop="testingDeptManagerId">
        <el-input v-model="queryParams.testingDeptManagerId" placeholder="请输入测试部主管id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试部主管审核意见" prop="managerRemark">
        <el-input v-model="queryParams.managerRemark" placeholder="请输入测试部主管审核意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试报告检查表ID" prop="table10Id">
        <el-input v-model="queryParams.table10Id" placeholder="请输入测试报告检查表ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="签字人审核意见" prop="signatoryRemark">
        <el-input v-model="queryParams.signatoryRemark" placeholder="请输入签字人审核意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="签字人id" prop="signatoryId">
        <el-input v-model="queryParams.signatoryId" placeholder="请输入签字人id" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="客户意见" prop="clientRemark">
        <el-input v-model="queryParams.clientRemark" placeholder="请输入客户意见" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['system:report:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:report:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="测试报告编号" align="center" prop="id" />
      <el-table-column label="软件测试报告ID" align="center" prop="table7Id" />
      <el-table-column label="测试用例（电子记录）ID" align="center" prop="table8Id" />
      <el-table-column label="软件测试记录(电子记录)ID" align="center" prop="table9Id" />
      <el-table-column label="软件测试问题清单（电子记录）ID" align="center" prop="table11Id" />
      <el-table-column label="测试部主管id" align="center" prop="testingDeptManagerId" />
      <el-table-column label="测试部主管审核意见" align="center" prop="managerRemark" />
      <el-table-column label="测试报告检查表ID" align="center" prop="table10Id" />
      <el-table-column label="签字人审核意见" align="center" prop="signatoryRemark" />
      <el-table-column label="签字人id" align="center" prop="signatoryId" />
      <el-table-column label="客户意见" align="center" prop="clientRemark" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:report:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:report:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="软件测试报告ID" prop="table7Id">
          <el-input v-model="form.table7Id" placeholder="请输入软件测试报告ID" />
        </el-form-item>
        <el-form-item label="测试用例（电子记录）ID" prop="table8Id">
          <el-input v-model="form.table8Id" placeholder="请输入测试用例（电子记录）ID" />
        </el-form-item>
        <el-form-item label="软件测试记录(电子记录)ID" prop="table9Id">
          <el-input v-model="form.table9Id" placeholder="请输入软件测试记录(电子记录)ID" />
        </el-form-item>
        <el-form-item label="软件测试问题清单（电子记录）ID" prop="table11Id">
          <el-input v-model="form.table11Id" placeholder="请输入软件测试问题清单（电子记录）ID" />
        </el-form-item>
        <el-form-item label="测试部主管id" prop="testingDeptManagerId">
          <el-input v-model="form.testingDeptManagerId" placeholder="请输入测试部主管id" />
        </el-form-item>
        <el-form-item label="测试部主管审核意见" prop="managerRemark">
          <el-input v-model="form.managerRemark" placeholder="请输入测试部主管审核意见" />
        </el-form-item>
        <el-form-item label="测试报告检查表ID" prop="table10Id">
          <el-input v-model="form.table10Id" placeholder="请输入测试报告检查表ID" />
        </el-form-item>
        <el-form-item label="签字人审核意见" prop="signatoryRemark">
          <el-input v-model="form.signatoryRemark" placeholder="请输入签字人审核意见" />
        </el-form-item>
        <el-form-item label="签字人id" prop="signatoryId">
          <el-input v-model="form.signatoryId" placeholder="请输入签字人id" />
        </el-form-item>
        <el-form-item label="客户意见" prop="clientRemark">
          <el-input v-model="form.clientRemark" placeholder="请输入客户意见" />
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
import { createReport, updateReport, deleteReport, getReport, getReportPage, exportReportExcel } from "@/api/system/report";

export default {
  name: "Report",
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
      // 测试报告列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        table7Id: null,
        table8Id: null,
        table9Id: null,
        table11Id: null,
        testingDeptManagerId: null,
        managerRemark: null,
        table10Id: null,
        signatoryRemark: null,
        signatoryId: null,
        clientRemark: null,
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
      getReportPage(this.queryParams).then(response => {
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
        table7Id: undefined,
        table8Id: undefined,
        table9Id: undefined,
        table11Id: undefined,
        testingDeptManagerId: undefined,
        managerRemark: undefined,
        table10Id: undefined,
        signatoryRemark: undefined,
        signatoryId: undefined,
        clientRemark: undefined,
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
      this.title = "添加测试报告";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getReport(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改测试报告";
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
          updateReport(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createReport(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除测试报告编号为"' + id + '"的数据项?').then(function() {
          return deleteReport(id);
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
      this.$modal.confirm('是否确认导出所有测试报告数据项?').then(() => {
          this.exportLoading = true;
          return exportReportExcel(params);
        }).then(response => {
          this.$download.excel(response, '测试报告.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
