import request from '@/utils/request'

// 创建用户和公司关联
export function createUserCompany(data) {
  return request({
    url: '/system/user-company/create',
    method: 'post',
    data: data
  })
}

// 更新用户和公司关联
export function updateUserCompany(data) {
  return request({
    url: '/system/user-company/update',
    method: 'put',
    data: data
  })
}

// 删除用户和公司关联
export function deleteUserCompany(id) {
  return request({
    url: '/system/user-company/delete?id=' + id,
    method: 'delete'
  })
}

// 获得用户和公司关联
export function getUserCompany(id) {
  return request({
    url: '/system/user-company/get?id=' + id,
    method: 'get'
  })
}

// 获得用户和公司关联分页
export function getUserCompanyPage(query) {
  return request({
    url: '/system/user-company/page',
    method: 'get',
    params: query
  })
}

// 导出用户和公司关联 Excel
export function exportUserCompanyExcel(query) {
  return request({
    url: '/system/user-company/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
