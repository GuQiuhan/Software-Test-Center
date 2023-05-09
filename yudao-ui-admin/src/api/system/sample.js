import request from '@/utils/request'

// 创建样品
export function createSample(data) {
  return request({
    url: '/system/sample/create',
    method: 'post',
    data: data
  })
}

// 更新样品
export function updateSample(data) {
  return request({
    url: '/system/sample/update',
    method: 'put',
    data: data
  })
}

// 删除样品
export function deleteSample(id) {
  return request({
    url: '/system/sample/delete?id=' + id,
    method: 'delete'
  })
}

// 获得样品
export function getSample(id) {
  return request({
    url: '/system/sample/get?id=' + id,
    method: 'get'
  })
}

// 获得样品分页
export function getSamplePage(query) {
  return request({
    url: '/system/sample/page',
    method: 'get',
    params: query
  })
}

// 导出样品 Excel
export function exportSampleExcel(query) {
  return request({
    url: '/system/sample/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
