import request from '@/utils/request'

// 创建动态表单列
export function createTable(data) {
  return request({
    url: '/dynamic/table/create',
    method: 'post',
    data: data
  })
}

// 更新动态表单列
export function updateTable(data) {
  return request({
    url: '/dynamic/table/update',
    method: 'put',
    data: data
  })
}

// 删除动态表单列
export function deleteTable(id) {
  return request({
    url: '/dynamic/table/delete?id=' + id,
    method: 'delete'
  })
}

// 获得动态表单列
export function getTable(id) {
  return request({
    url: '/dynamic/table/get?id=' + id,
    method: 'get'
  })
}

// 获得动态表单列分页
export function getTablePage(query) {
  return request({
    url: '/dynamic/table/page',
    method: 'get',
    params: query
  })
}

// 导出动态表单列 Excel
export function exportTableExcel(query) {
  return request({
    url: '/dynamic/table/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
