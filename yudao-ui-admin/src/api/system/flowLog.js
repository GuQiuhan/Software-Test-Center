import request from '@/utils/request'

// 创建流程日志
export function createFlowLog(data) {
  return request({
    url: '/system/flow-log/create',
    method: 'post',
    data: data
  })
}

// 更新流程日志
export function updateFlowLog(data) {
  return request({
    url: '/system/flow-log/update',
    method: 'put',
    data: data
  })
}

// 删除流程日志
export function deleteFlowLog(id) {
  return request({
    url: '/system/flow-log/delete?id=' + id,
    method: 'delete'
  })
}

// 获得流程日志
export function getFlowLog(id) {
  return request({
    url: '/system/flow-log/get?id=' + id,
    method: 'get'
  })
}

// 获得流程日志分页
export function getFlowLogPage(query) {
  return request({
    url: '/system/flow-log/page',
    method: 'get',
    params: query
  })
}

// 导出流程日志 Excel
export function exportFlowLogExcel(query) {
  return request({
    url: '/system/flow-log/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
