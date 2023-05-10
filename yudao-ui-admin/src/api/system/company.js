import request from '@/utils/request'

// 创建公司
export function createCompany(data) {
  return request({
    url: '/system/company/create',
    method: 'post',
    data: data
  })
}

// 更新公司
export function updateCompany(data) {
  return request({
    url: '/system/company/update',
    method: 'put',
    data: data
  })
}

// 删除公司
export function deleteCompany(id) {
  return request({
    url: '/system/company/delete?id=' + id,
    method: 'delete'
  })
}

// 获得公司
export function getCompany(id) {
  return request({
    url: '/system/company/get?id=' + id,
    method: 'get'
  })
}

// 获得公司分页
export function getCompanyPage(query) {
  return request({
    url: '/system/company/page',
    method: 'get',
    params: query
  })
}

// 导出公司 Excel
export function exportCompanyExcel(query) {
  return request({
    url: '/system/company/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
