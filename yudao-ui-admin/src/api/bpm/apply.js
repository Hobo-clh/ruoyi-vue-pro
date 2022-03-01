import request from '@/utils/request'

// 创建请假申请
export function createApply(data) {
  return request({
    url: '/bpm/oa/apply/create',
    method: 'post',
    data: data
  })
}

// 获得请假申请
export function getApply(id) {
  return request({
    url: '/bpm/oa/apply/get?id=' + id,
    method: 'get'
  })
}

// 获得请假申请分页
export function getApplyPage(query) {
  return request({
    url: '/bpm/oa/apply/page',
    method: 'get',
    params: query
  })
}
