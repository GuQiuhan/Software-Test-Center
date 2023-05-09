<template>
  <div class="app-container">

    <!-- 搜索工作栏 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="发起时间" prop="launchTime">
        <el-date-picker v-model="queryParams.launchTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="发起者编号" prop="creatorId">
        <el-input v-model="queryParams.creatorId" placeholder="请输入发起者编号" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="委托名称" prop="name">
        <el-input v-model="queryParams.name" placeholder="请输入委托名称" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="软件项目委托测试申请表ID" prop="table2Id">
        <el-input v-model="queryParams.table2Id" placeholder="请输入软件项目委托测试申请表ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="委托测试软件功能列表ID" prop="table3Id">
        <el-input v-model="queryParams.table3Id" placeholder="请输入委托测试软件功能列表ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="文档材料url" prop="url">
        <el-input v-model="queryParams.url" placeholder="请输入文档材料url" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分配的市场部人员ID" prop="marketDeptStaffId">
        <el-input v-model="queryParams.marketDeptStaffId" placeholder="请输入分配的市场部人员ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="分配的测试部人员ID" prop="testingDeptStaffId">
        <el-input v-model="queryParams.testingDeptStaffId" placeholder="请输入分配的测试部人员ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="市场部人员处理意见" prop="marketRemark">
        <el-input v-model="queryParams.marketRemark" placeholder="请输入市场部人员处理意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试部人员处理意见" prop="testingRemark">
        <el-input v-model="queryParams.testingRemark" placeholder="请输入测试部人员处理意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="软件文档评审表ID" prop="table14Id">
        <el-input v-model="queryParams.table14Id" placeholder="请输入软件文档评审表ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="报价单ID" prop="offerId">
        <el-input v-model="queryParams.offerId" placeholder="请输入报价单ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="用户报价单意见" prop="offerRemark">
        <el-input v-model="queryParams.offerRemark" placeholder="请输入用户报价单意见" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="合同ID" prop="contractId">
        <el-input v-model="queryParams.contractId" placeholder="请输入合同ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="样品ID" prop="sampleId">
        <el-input v-model="queryParams.sampleId" placeholder="请输入样品ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试方案ID" prop="solutionId">
        <el-input v-model="queryParams.solutionId" placeholder="请输入测试方案ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="测试报告ID" prop="reportId">
        <el-input v-model="queryParams.reportId" placeholder="请输入测试报告ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态" prop="state">
        <el-select v-model="queryParams.state" placeholder="请选择状态" clearable size="small">
          <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
                       :key="dict.value" :label="dict.label" :value="dict.value"/>
        </el-select>
      </el-form-item>
      <el-form-item label="委托取消原因" prop="cancelRemark">
        <el-input v-model="queryParams.cancelRemark" placeholder="请输入委托取消原因" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="创建时间" prop="createTime">
        <el-date-picker v-model="queryParams.createTime" style="width: 240px" value-format="yyyy-MM-dd HH:mm:ss" type="daterange"
                        range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['00:00:00', '23:59:59']" />
      </el-form-item>
      <el-form-item label="软件项目委托测试工作检查表ID" prop="table12Id">
        <el-input v-model="queryParams.table12Id" placeholder="请输入软件项目委托测试工作检查表ID" clearable @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="项目编号" prop="projectId">
        <el-input v-model="queryParams.projectId" placeholder="请输入项目编号" clearable @keyup.enter.native="handleQuery"/>
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
                   v-hasPermi="['system:delegation:create']">新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport" :loading="exportLoading"
                   v-hasPermi="['system:delegation:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <!-- 列表 -->
    <el-table v-loading="loading" :data="list">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="发起时间" align="center" prop="launchTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.launchTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="发起者编号" align="center" prop="creatorId" />
      <el-table-column label="委托名称" align="center" prop="name" />
      <el-table-column label="软件项目委托测试申请表ID" align="center" prop="table2Id" />
      <el-table-column label="委托测试软件功能列表ID" align="center" prop="table3Id" />
      <el-table-column label="文档材料url" align="center" prop="url" />
      <el-table-column label="分配的市场部人员ID" align="center" prop="marketDeptStaffId" />
      <el-table-column label="分配的测试部人员ID" align="center" prop="testingDeptStaffId" />
      <el-table-column label="市场部人员处理意见" align="center" prop="marketRemark" />
      <el-table-column label="测试部人员处理意见" align="center" prop="testingRemark" />
      <el-table-column label="软件文档评审表ID" align="center" prop="table14Id" />
      <el-table-column label="报价单ID" align="center" prop="offerId" />
      <el-table-column label="用户报价单意见" align="center" prop="offerRemark" />
      <el-table-column label="合同ID" align="center" prop="contractId" />
      <el-table-column label="样品ID" align="center" prop="sampleId" />
      <el-table-column label="测试方案ID" align="center" prop="solutionId" />
      <el-table-column label="测试报告ID" align="center" prop="reportId" />
      <el-table-column label="状态" align="center" prop="state">
        <template v-slot="scope">
          <dict-tag :type="DICT_TYPE.COMMON_STATUS" :value="scope.row.state" />
        </template>
      </el-table-column>
      <el-table-column label="委托取消原因" align="center" prop="cancelRemark" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template v-slot="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="软件项目委托测试工作检查表ID" align="center" prop="table12Id" />
      <el-table-column label="项目编号" align="center" prop="projectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template v-slot="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                     v-hasPermi="['system:delegation:update']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                     v-hasPermi="['system:delegation:delete']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件 -->
    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNo" :limit.sync="queryParams.pageSize"
                @pagination="getList"/>

    <!-- 对话框(添加 / 修改) -->
    <el-dialog :title="title" :visible.sync="open" width="500px" v-dialogDrag append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="发起时间" prop="launchTime">
          <el-date-picker clearable v-model="form.launchTime" type="date" value-format="timestamp" placeholder="选择发起时间" />
        </el-form-item>
        <el-form-item label="发起者编号" prop="creatorId">
          <el-input v-model="form.creatorId" placeholder="请输入发起者编号" />
        </el-form-item>
        <el-form-item label="委托名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入委托名称" />
        </el-form-item>
        <el-form-item label="软件项目委托测试申请表ID" prop="table2Id">
          <el-input v-model="form.table2Id" placeholder="请输入软件项目委托测试申请表ID" />
        </el-form-item>
        <el-form-item label="委托测试软件功能列表ID" prop="table3Id">
          <el-input v-model="form.table3Id" placeholder="请输入委托测试软件功能列表ID" />
        </el-form-item>
        <el-form-item label="文档材料url" prop="url">
          <el-input v-model="form.url" placeholder="请输入文档材料url" />
        </el-form-item>
        <el-form-item label="分配的市场部人员ID" prop="marketDeptStaffId">
          <el-input v-model="form.marketDeptStaffId" placeholder="请输入分配的市场部人员ID" />
        </el-form-item>
        <el-form-item label="分配的测试部人员ID" prop="testingDeptStaffId">
          <el-input v-model="form.testingDeptStaffId" placeholder="请输入分配的测试部人员ID" />
        </el-form-item>
        <el-form-item label="市场部人员处理意见" prop="marketRemark">
          <el-input v-model="form.marketRemark" placeholder="请输入市场部人员处理意见" />
        </el-form-item>
        <el-form-item label="测试部人员处理意见" prop="testingRemark">
          <el-input v-model="form.testingRemark" placeholder="请输入测试部人员处理意见" />
        </el-form-item>
        <el-form-item label="软件文档评审表ID" prop="table14Id">
          <el-input v-model="form.table14Id" placeholder="请输入软件文档评审表ID" />
        </el-form-item>
        <el-form-item label="报价单ID" prop="offerId">
          <el-input v-model="form.offerId" placeholder="请输入报价单ID" />
        </el-form-item>
        <el-form-item label="用户报价单意见" prop="offerRemark">
          <el-input v-model="form.offerRemark" placeholder="请输入用户报价单意见" />
        </el-form-item>
        <el-form-item label="合同ID" prop="contractId">
          <el-input v-model="form.contractId" placeholder="请输入合同ID" />
        </el-form-item>
        <el-form-item label="样品ID" prop="sampleId">
          <el-input v-model="form.sampleId" placeholder="请输入样品ID" />
        </el-form-item>
        <el-form-item label="测试方案ID" prop="solutionId">
          <el-input v-model="form.solutionId" placeholder="请输入测试方案ID" />
        </el-form-item>
        <el-form-item label="测试报告ID" prop="reportId">
          <el-input v-model="form.reportId" placeholder="请输入测试报告ID" />
        </el-form-item>
        <el-form-item label="状态" prop="state">
          <el-select v-model="form.state" placeholder="请选择状态">
            <el-option v-for="dict in this.getDictDatas(DICT_TYPE.COMMON_STATUS)"
                       :key="dict.value" :label="dict.label" :value="parseInt(dict.value)" />
          </el-select>
        </el-form-item>
        <el-form-item label="委托取消原因" prop="cancelRemark">
          <el-input v-model="form.cancelRemark" placeholder="请输入委托取消原因" />
        </el-form-item>
        <el-form-item label="软件项目委托测试工作检查表ID" prop="table12Id">
          <el-input v-model="form.table12Id" placeholder="请输入软件项目委托测试工作检查表ID" />
        </el-form-item>
        <el-form-item label="项目编号" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目编号" />
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
import { createDelegation, updateDelegation, deleteDelegation, getDelegation, getDelegationPage, exportDelegationExcel } from "@/api/system/delegation";

export default {
  name: "Delegation",
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
      // 委托列表
      list: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNo: 1,
        pageSize: 10,
        launchTime: [],
        creatorId: null,
        name: null,
        table2Id: null,
        table3Id: null,
        url: null,
        marketDeptStaffId: null,
        testingDeptStaffId: null,
        marketRemark: null,
        testingRemark: null,
        table14Id: null,
        offerId: null,
        offerRemark: null,
        contractId: null,
        sampleId: null,
        solutionId: null,
        reportId: null,
        state: null,
        cancelRemark: null,
        createTime: [],
        table12Id: null,
        projectId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        launchTime: [{ required: true, message: "发起时间不能为空", trigger: "blur" }],
        name: [{ required: true, message: "委托名称不能为空", trigger: "blur" }],
        state: [{ required: true, message: "状态不能为空", trigger: "change" }],
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
      getDelegationPage(this.queryParams).then(response => {
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
        launchTime: undefined,
        creatorId: undefined,
        name: undefined,
        table2Id: undefined,
        table3Id: undefined,
        url: undefined,
        marketDeptStaffId: undefined,
        testingDeptStaffId: undefined,
        marketRemark: undefined,
        testingRemark: undefined,
        table14Id: undefined,
        offerId: undefined,
        offerRemark: undefined,
        contractId: undefined,
        sampleId: undefined,
        solutionId: undefined,
        reportId: undefined,
        state: undefined,
        cancelRemark: undefined,
        table12Id: undefined,
        projectId: undefined,
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
      this.title = "添加委托";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id;
      getDelegation(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改委托";
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
          updateDelegation(this.form).then(response => {
            this.$modal.msgSuccess("修改成功");
            this.open = false;
            this.getList();
          });
          return;
        }
        // 添加的提交
        createDelegation(this.form).then(response => {
          this.$modal.msgSuccess("新增成功");
          this.open = false;
          this.getList();
        });
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const id = row.id;
      this.$modal.confirm('是否确认删除委托编号为"' + id + '"的数据项?').then(function() {
          return deleteDelegation(id);
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
      this.$modal.confirm('是否确认导出所有委托数据项?').then(() => {
          this.exportLoading = true;
          return exportDelegationExcel(params);
        }).then(response => {
          this.$download.excel(response, '委托.xls');
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
