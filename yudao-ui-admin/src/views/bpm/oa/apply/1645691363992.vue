<template>
  <div>
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-col :span="13">
          <el-form-item label="开始时间" prop="field101">
            <el-time-picker v-model="formData.field101" format="HH:mm:ss" value-format="HH:mm:ss"
              :picker-options='{"selectableRange":"00:00:00-23:59:59"}' :style="{width: '100%'}"
              placeholder="请选择开始时间" clearable></el-time-picker>
          </el-form-item>
        </el-col>
        <el-col :span="13">
          <el-form-item label="结束时间" prop="field102">
            <el-time-picker v-model="formData.field102" format="HH:mm:ss" value-format="HH:mm:ss"
              :picker-options='{"selectableRange":"00:00:00-23:59:59"}' :style="{width: '100%'}"
              placeholder="请选择结束时间" clearable></el-time-picker>
          </el-form-item>
        </el-col>
        <el-col :span="13">
          <el-form-item label="时间" prop="field104">
            <el-time-picker v-model="formData.field104" format="HH:mm:ss" value-format="HH:mm:ss"
              :picker-options='{"selectableRange":"00:00:00-23:59:59"}' :style="{width: '100%'}"
              placeholder="请选择时间" clearable></el-time-picker>
          </el-form-item>
        </el-col>
        <el-col :span="13">
          <el-form-item label="请假类型" prop="field106">
            <el-select v-model="formData.field106" placeholder="请选择请假类型" clearable :style="{width: '100%'}">
              <el-option v-for="(item, index) in field106Options" :key="index" :label="item.label"
                :value="item.value" :disabled="item.disabled"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="13">
          <el-form-item label="原因" prop="field108">
            <el-input v-model="formData.field108" type="textarea" placeholder="请输入原因" :maxlength="100"
              :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        field101: "01:00:11",
        field102: "01:00:11",
        field104: "16:26:21",
        field106: undefined,
        field108: undefined,
      },
      rules: {
        field101: [{
          required: true,
          message: '请选择开始时间',
          trigger: 'change'
        }],
        field102: [{
          required: true,
          message: '请选择结束时间',
          trigger: 'change'
        }],
        field104: [{
          required: true,
          message: '请选择时间',
          trigger: 'change'
        }],
        field106: [{
          required: true,
          message: '请选择请假类型',
          trigger: 'change'
        }],
        field108: [{
          required: true,
          message: '请输入原因',
          trigger: 'blur'
        }],
      },
      field106Options: [{
        "label": "选项一",
        "value": 1
      }, {
        "label": "选项二",
        "value": 2
      }],
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
