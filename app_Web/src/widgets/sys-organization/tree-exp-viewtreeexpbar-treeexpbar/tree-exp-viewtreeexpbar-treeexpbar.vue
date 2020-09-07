<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TreeExpViewtreeexpbarBase from './tree-exp-viewtreeexpbar-treeexpbar-base.vue';
import view_treeexpbar_tree from '@widgets/sys-organization/org-tree-treeview/org-tree-treeview.vue';

 
@Component({
    components: {
        view_treeexpbar_tree, 
         
    }
})
export default class TreeExpViewtreeexpbar extends TreeExpViewtreeexpbarBase {

}
</script>