import request from '@/utils/request'

// 创建测试方案
export function createSolution(data) {
  return request({
    url: '/system/solution/create',
    method: 'post',
    data: data
  })
}

// 更新测试方案
export function updateSolution(data) {
  return request({
    url: '/system/solution/update',
    method: 'put',
    data: data
  })
}

// 删除测试方案
export function deleteSolution(id) {
  return request({
    url: '/system/solution/delete?id=' + id,
    method: 'delete'
  })
}

// 获得测试方案
export function getSolution(id) {
  return request({
    url: '/system/solution/get?id=' + id,
    method: 'get'
  })
}

// 获得测试方案分页
export function getSolutionPage(query) {
  return request({
    url: '/system/solution/page',
    method: 'get',
    params: query
  })
}

// 导出测试方案 Excel
export function exportSolutionExcel(query) {
  return request({
    url: '/system/solution/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
