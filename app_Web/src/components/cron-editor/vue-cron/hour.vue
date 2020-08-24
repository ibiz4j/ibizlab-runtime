<template lang="html">
  <div :val="value_">
    <div>
      <el-radio v-model="type" label="1" size="mini" border>{{ $t('components.cronEditor.hour.everyHour') }}</el-radio>
    </div>
    <div>
      <el-radio v-model="type" label="2" size="mini" border>{{ $t('components.cronEditor.public.cycle') }}</el-radio>
      <span style="margin-left: 10px; margin-right: 5px;">{{ $t('components.cronEditor.public.from') }}</span>
      <el-input-number @change="type = '2'" v-model="cycle.start" :min="0" :max="23" size="mini" style="width: 100px;"></el-input-number>
      <span style="margin-left: 5px; margin-right: 5px;">{{ $t('components.cronEditor.public.to') }}</span>
      <el-input-number @change="type = '2'" v-model="cycle.end" :min="2" :max="23" size="mini" style="width: 100px;"></el-input-number>
      {{ $t('components.cronEditor.hour.title') }}
    </div>
    <div>
      <el-radio v-model="type" label="3" size="mini" border>{{ $t('components.cronEditor.public.loop') }}</el-radio>
      <span style="margin-left: 10px; margin-right: 5px;">{{ $t('components.cronEditor.public.from') }}</span>
      <el-input-number @change="type = '3'" v-model="loop.start" :min="0" :max="23" size="mini" style="width: 100px;"></el-input-number>
      <span style="margin-left: 5px; margin-right: 5px;">{{ $t('components.cronEditor.hour.hourStart') }}</span>
      <el-input-number @change="type = '3'" v-model="loop.end" :min="1" :max="23" size="mini" style="width: 100px;"></el-input-number>
      {{ $t('components.cronEditor.hour.onceAHour') }}
    </div>
    <div>
      <el-radio v-model="type" label="4" size="mini" border>{{ $t('components.cronEditor.public.specify') }}</el-radio>
      <el-checkbox-group v-model="appoint">
        <div  v-for="i in 3" :key="i" style="margin-left: 10px;  line-height: 25px;">
          <template v-for="j in 10">
            <el-checkbox @change="type = '4'" v-if="parseInt((i - 1) + '' + (j - 1)) < 24" :key="j" :label="(i - 1) + '' + (j - 1)"></el-checkbox>
          </template>
        </div>
      </el-checkbox-group>
    </div>
  </div>
</template>

<script lang='ts'>
import { Vue, Watch, Component } from 'vue-property-decorator';
@Component({})
export default class Hour extends Vue {

    /**
     * Cron表达式
     *
     * @type {any}
     * @memberof Day
     */ 
    public value: any;

    /**
     * 标签类型标识
     *
     * @type {any}
     * @memberof Day
     */ 
    public type: string = '1';

    /**
     * 周期
     *
     * @type {any}
     * @memberof Day
     */ 
    public cycle: any = {
        start: 0,
        end: 0
    };

    /**
     * 循环
     *
     * @type {any}
     * @memberof Day
     */ 
    public loop: any = {
        start: 0,
        end: 0
    }

    /**
     * 周
     *
     * @type {any}
     * @memberof Day
     */ 
    public week: any = {
        start: 0,
        end: 0
    }

    /**
     * 工作日
     *
     * @type {any}
     * @memberof Day
     */ 
    public work: number = 0;

    /**
     * 最后
     *
     * @type {any}
     * @memberof Day
     */ 
    public last: number = 0;

    /**
     * 指定
     *
     * @type {any}
     * @memberof Day
     */ 
    public appoint: any = [];

    /**
     * 获取Cron表达式
     * 
     * @returns
     * @memberof Day
     */
    get value_() {
        let result: any = [];
        switch (this.type) {
          case '1': // 每秒
            result.push('*')
            break;
          case '2': // 年期
            result.push(`${this.cycle.start}-${this.cycle.end}`)
            break;
          case '3': // 循环
            result.push(`${this.loop.start}/${this.loop.end}`)
            break;
          case '4': // 指定
            result.push(this.appoint.join(','))
            break;
          case '6': // 最后
            result.push(`${this.last === 0 ? '' : this.last}L`)
            break;
          default: // 不指定
            result.push('?')
            break;
        }
      this.$emit('input', result.join(''));
      return result.join('');
    }

    /**
     * 数据值变化
     * 
     * @returns
     * @memberof Hour
     */
    @Watch('value')
    public updateVal() {
      if (!this.value) {
        return
      }
      if (this.value === '?') {
        this.type = '5'
      } else if (this.value.indexOf('-') !== -1) { // 2周期
        if (this.value.split('-').length === 2) {
          this.type = '2'
          this.cycle.start = this.value.split('-')[0]
          this.cycle.end = this.value.split('-')[1]
        }
      } else if (this.value.indexOf('/') !== -1) { // 3循环
        if (this.value.split('/').length === 2) {
          this.type = '3'
          this.loop.start = this.value.split('/')[0]
          this.loop.end = this.value.split('/')[1]
        }
      } else if (this.value.indexOf('*') !== -1) { // 1每
        this.type = '1'
      } else if (this.value.indexOf('L') !== -1) { // 6最后
        this.type = '6'
        this.last = this.value.replace('L', '')
      } else if (this.value.indexOf('#') !== -1) { // 7指定周
        if (this.value.split('#').length === 2) {
          this.type = '7'
          this.week.start = this.value.split('#')[0]
          this.week.end = this.value.split('#')[1]
        }
      } else if (this.value.indexOf('W') !== -1) { // 8工作日
        this.type = '8'
        this.work = this.value.replace('W', '')
      } else { // *
        this.type = '4'
        this.appoint = this.value.split(',')
      }
    }
  
    /**
     * Vue生命周期
     * 
     * @returns
     * @memberof Day
     */
    public created () {
      this.updateVal()
    }

}
</script>

<style lang="css">
.el-checkbox+.el-checkbox {
    margin-left: 10px;
}
</style>
