<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import JobsRegistryEditViewBase from './jobs-registry-edit-view-base.vue';

import view_form from '@widgets/jobs-registry/main-form/main-form.vue';
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class JobsRegistryEditView extends JobsRegistryEditViewBase {

}
</script>