import request from '@/utils/request'

// 创建前台菜单
export function createFrontMenu(data) {
  return request({
    url: '/system/front-menu/create',
    method: 'post',
    data: data
  })
}

// 更新前台菜单
export function updateFrontMenu(data) {
  return request({
    url: '/system/front-menu/update',
    method: 'put',
    data: data
  })
}

// 删除前台菜单
export function deleteFrontMenu(id) {
  return request({
    url: '/system/front-menu/delete?id=' + id,
    method: 'delete'
  })
}

// 获得前台菜单
export function getFrontMenu(id) {
  return request({
    url: '/system/front-menu/get?id=' + id,
    method: 'get'
  })
}

// 获得前台菜单分页
export function getFrontMenuPage(query) {
  return request({
    url: '/system/front-menu/page',
    method: 'get',
    params: query
  })
}

// 导出前台菜单 Excel
export function exportFrontMenuExcel(query) {
  return request({
    url: '/system/front-menu/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
