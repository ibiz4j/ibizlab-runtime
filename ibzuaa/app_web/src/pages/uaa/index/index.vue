<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import IndexBase from './index-base.vue';

import view_appmenu from '@widgets/app/main-appmenu/main-appmenu.vue';
@Component({
    components: {
        view_appmenu, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class Index extends IndexBase {

}
</script>