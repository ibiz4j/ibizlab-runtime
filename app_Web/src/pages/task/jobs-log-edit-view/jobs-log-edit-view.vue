<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import JobsLogEditViewBase from './jobs-log-edit-view-base.vue';

import view_form from '@widgets/jobs-log/main-form/main-form.vue';
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            if(!Object.is(vm.navModel,"route")){
                vm.initNavDataWithTab(vm.viewCacheData);
            }
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class JobsLogEditView extends JobsLogEditViewBase {

}
</script>