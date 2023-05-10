import request from '@/utils/request'

// 创建委托
export function createDelegation(data) {
  return request({
    url: '/system/delegation/create',
    method: 'post',
    data: data
  })
}

// 更新委托
export function updateDelegation(data) {
  return request({
    url: '/system/delegation/update',
    method: 'put',
    data: data
  })
}

// 删除委托
export function deleteDelegation(id) {
  return request({
    url: '/system/delegation/delete?id=' + id,
    method: 'delete'
  })
}

// 获得委托
export function getDelegation(id) {
  return request({
    url: '/system/delegation/get?id=' + id,
    method: 'get'
  })
}

// 获得委托分页
export function getDelegationPage(query) {
  return request({
    url: '/system/delegation/page',
    method: 'get',
    params: query
  })
}

// 导出委托 Excel
export function exportDelegationExcel(query) {
  return request({
    url: '/system/delegation/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
