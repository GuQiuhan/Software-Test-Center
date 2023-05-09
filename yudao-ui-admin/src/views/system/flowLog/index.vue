<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="委托的编号" prop="delegationId">
        <el-input v-model="queryParams.delegationId" placeholder="请输入委托的编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="现状态" prop="toState">
        <el-input v-model="queryParams.toState" placeholder="请输入现状态" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="操作人编号" prop="operatorId">
        <el-input v-model="queryParams.operatorId" placeholder="请输入操作人编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="日志时间" prop="operateTime">
        <el-date-picker v-model="queryParams.operateTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="日志信息" prop="remark">
        <el-input v-model="queryParams.remark" placeholder="请输入日志信息" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="日志变量" prop="mapValue">
        <el-input v-model="queryParams.mapValue" placeholder="请输入日志变量" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="原状态" prop="fromState">
        <el-input v-model="queryParams.fromState" placeholder="请输入原状态" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['system:flow-log:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:flow-log:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="委托的编号" align="center" prop="delegationId" />
      <el-table-column label="现状态" align="center" prop="toState" />
      <el-table-column label="操作人编号" align="center" prop="operatorId" />
      <el-table-column label="日志时间" align="center" prop="operateTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.operateTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="日志信息" align="center" prop="remark" />
      <el-table-column label="日志变量" align="center" prop="mapValue" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="原状态" align="center" prop="fromState" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:flow-log:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:flow-log:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="委托的编号" prop="delegationId">
          <el-input v-model="form.delegationId" placeholder="请输入委托的编号" />
        </el-form-item>
        <el-form-item label="现状态" prop="toState">
          <el-input v-model="form.toState" placeholder="请输入现状态" />
        </el-form-item>
        <el-form-item label="操作人编号" prop="operatorId">
          <el-input v-model="form.operatorId" placeholder="请输入操作人编号" />
        </el-form-item>
        <el-form-item label="日志时间" prop="operateTime">
          <el-date-picker clearable v-model="form.operateTime" type="date" value-format="timestamp" placeholder="选择日志时间" />
        </el-form-item>
        <el-form-item label="日志信息" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入日志信息" />
        </el-form-item>
        <el-form-item label="日志变量" prop="mapValue">
          <el-input v-model="form.mapValue" placeholder="请输入日志变量" />
        </el-form-item>
        <el-form-item label="原状态" prop="fromState">
          <el-input v-model="form.fromState" placeholder="请输入原状态" />
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
import { createFlowLog, updateFlowLog, deleteFlowLog, getFlowLog, getFlowLogPage, exportFlowLogExcel } from "@/api/system/flowLog";

export default {
  name: "FlowLog",
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
      // 流程日志列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        delegationId: null,
        toState: null,
        operatorId: null,
        operateTime: [],
        remark: null,
        mapValue: null,
        createTime: [],
        fromState: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        delegationId: [{ required: true, message: "委托的编号不能为空", trigger: "blur" }],
        toState: [{ required: true, message: "现状态不能为空", trigger: "blur" }],
        operatorId: [{ required: true, message: "操作人编号不能为空", trigger: "blur" }],
        operateTime: [{ required: true, message: "日志时间不能为空", trigger: "blur" }],
        remark: [{ required: true, message: "日志信息不能为空", trigger: "blur" }],
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
      getFlowLogPage(this.queryParams).then(response => {
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
        delegationId: undefined,
        toState: undefined,
        operatorId: undefined,
        operateTime: undefined,
        remark: undefined,
        mapValue: undefined,
        fromState: undefined,
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
      this.title = "添加流程日志";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getFlowLog(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改流程日志";
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
          updateFlowLog(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createFlowLog(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除流程日志编号为"' + id + '"的数据项?').then(function() {
          return deleteFlowLog(id);
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
      this.$modal.confirm('是否确认导出所有流程日志数据项?').then(() => {
          this.exportLoading = true;
          return exportFlowLogExcel(params);
        }).then(response => {
          this.$download.excel(response, '流程日志.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
