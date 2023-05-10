import request from '@/utils/request'

// 创建测试报告

export function createReport(data) {
  return request({
    url: '/system/report/create',
    method: 'post',
    data: data
  })
}

// 更新测试报告

export function updateReport(data) {
  return request({
    url: '/system/report/update',
    method: 'put',
    data: data
  })
}

// 删除测试报告

export function deleteReport(id) {
  return request({
    url: '/system/report/delete?id=' + id,
    method: 'delete'
  })
}

// 获得测试报告

export function getReport(id) {
  return request({
    url: '/system/report/get?id=' + id,
    method: 'get'
  })
}

// 获得测试报告
分页
export function getReportPage(query) {
  return request({
    url: '/system/report/page',
    method: 'get',
    params: query
  })
}

// 导出测试报告
 Excel
export function exportReportExcel(query) {
  return request({
    url: '/system/report/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
