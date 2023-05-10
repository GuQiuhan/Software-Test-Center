import request from '@/utils/request'

// 创建角色前台菜单
export function createRoleFrontMenu(data) {
  return request({
    url: '/system/role-front-menu/create',
    method: 'post',
    data: data
  })
}

// 更新角色前台菜单
export function updateRoleFrontMenu(data) {
  return request({
    url: '/system/role-front-menu/update',
    method: 'put',
    data: data
  })
}

// 删除角色前台菜单
export function deleteRoleFrontMenu(id) {
  return request({
    url: '/system/role-front-menu/delete?id=' + id,
    method: 'delete'
  })
}

// 获得角色前台菜单
export function getRoleFrontMenu(id) {
  return request({
    url: '/system/role-front-menu/get?id=' + id,
    method: 'get'
  })
}

// 获得角色前台菜单分页
export function getRoleFrontMenuPage(query) {
  return request({
    url: '/system/role-front-menu/page',
    method: 'get',
    params: query
  })
}

// 导出角色前台菜单 Excel
export function exportRoleFrontMenuExcel(query) {
  return request({
    url: '/system/role-front-menu/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
