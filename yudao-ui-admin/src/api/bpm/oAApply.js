import request from '@/utils/request'

// 创建OA 申请
export function createOAApply(data) {
  return request({
    url: '/bpm/OAA-pply/create',
    method: 'post',
    data: data
  })
}

// 更新OA 申请
export function updateOAApply(data) {
  return request({
    url: '/bpm/OAA-pply/update',
    method: 'put',
    data: data
  })
}

// 删除OA 申请
export function deleteOAApply(id) {
  return request({
    url: '/bpm/OAA-pply/delete?id=' + id,
    method: 'delete'
  })
}

// 获得OA 申请
export function getOAApply(id) {
  return request({
    url: '/bpm/OAA-pply/get?id=' + id,
    method: 'get'
  })
}

// 获得OA 申请分页
export function getOAApplyPage(query) {
  return request({
    url: '/bpm/OAA-pply/page',
    method: 'get',
    params: query
  })
}

// 导出OA 申请 Excel
export function exportOAApplyExcel(query) {
  return request({
    url: '/bpm/OAA-pply/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
