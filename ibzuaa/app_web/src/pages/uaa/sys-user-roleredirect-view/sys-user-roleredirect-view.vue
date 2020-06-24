<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SYS_USER_ROLERedirectViewBase from './sys-user-roleredirect-view-base.vue';

@Component({
    components: {
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
export default class SYS_USER_ROLERedirectView extends SYS_USER_ROLERedirectViewBase {

}
</script>