<template>
  <div class="app-container">
    <!-- 对话框(添加 / 修改) -->
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable size="small" v-model="form.startTime" type="date" value-format="timestamp" placeholder="选择开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable size="small" v-model="form.endTime" type="date" value-format="timestamp" placeholder="选择结束时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="time">
          <el-date-picker clearable size="small" v-model="form.time" type="date" value-format="timestamp" placeholder="选择时间" />
        </el-form-item>
        <el-form-item label="请假类型" prop="type">
          <el-select v-model="form.type" placeholder="请选择">
            <el-option v-for="dict in typeDictData" :key="parseInt(dict.value)" :label="dict.label" :value="parseInt(dict.value)"/>
          </el-select>
        </el-form-item>
        <el-form-item label="原因" prop="reason">
          <el-col :span="10">
            <el-input type="textarea" :rows="3" v-model="form.reason" placeholder="请输入原因" />
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm">提 交</el-button>
        </el-form-item>
      </el-form>
  </div>
</template>

<script>
import { createApply}  from "@/api/bpm/apply"
import { getDictDatas, DICT_TYPE } from '@/utils/dict'

export default {
  name: "ApplyCreate",
  components: {
  },
  data() {
    return {
      // 表单参数
      form: {
        startTime: undefined,
        endTime: undefined,
        type: undefined,
        reason: undefined,
        time: undefined
      },
      // 表单校验
      rules: {
        startTime: [{ required: true, message: "开始时间不能为空", trigger: "blur" }],
        endTime: [{ required: true, message: "结束时间不能为空", trigger: "blur" }],
        type: [{ required: true, message: "请假类型不能为空", trigger: "change" }],
        reason: [{ required: true, message: "请假原因不能为空", trigger: "change" }],
        time: [{ required: true, message: "时间不能为空", trigger: "blur" }],
      },

      typeDictData: getDictDatas(DICT_TYPE.BPM_OA_LEAVE_TYPE),
    };
  },
  created() {
  },
  methods: {
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (!valid) {
          return;
        }

        // 添加的提交
        createApply(this.form).then(response => {
          this.$modal.msgSuccess("发起成功");
          this.$tab.closeOpenPage({ path: "/bpm/oa/apply" });
        });
      });
    }
  }
};
</script>
