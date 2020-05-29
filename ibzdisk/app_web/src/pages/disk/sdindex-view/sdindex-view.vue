<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SDIndexViewBase from './sdindex-view-base.vue';

import view_appmenu from '@widgets/app/sdindex-view-appmenu/sdindex-view-appmenu.vue';
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
export default class SDIndexView extends SDIndexViewBase {

}
</script>