import request from '@/utils/request'

// 创建流程操作
export function createOperation(data) {
  return request({
    url: '/system/operation/create',
    method: 'post',
    data: data
  })
}

// 更新流程操作
export function updateOperation(data) {
  return request({
    url: '/system/operation/update',
    method: 'put',
    data: data
  })
}

// 删除流程操作
export function deleteOperation(id) {
  return request({
    url: '/system/operation/delete?id=' + id,
    method: 'delete'
  })
}

// 获得流程操作
export function getOperation(id) {
  return request({
    url: '/system/operation/get?id=' + id,
    method: 'get'
  })
}

// 获得流程操作分页
export function getOperationPage(query) {
  return request({
    url: '/system/operation/page',
    method: 'get',
    params: query
  })
}

// 导出流程操作 Excel
export function exportOperationExcel(query) {
  return request({
    url: '/system/operation/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
