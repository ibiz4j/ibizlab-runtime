
/**
 * 创建视图
 * 
 * @param state 
 * @param param1 
 */
export const createdView = (state: any, { viewtag, secondtag }: { viewtag: string, secondtag: string }) => {
    // 原始数据中是否存在
    const appview = state.appviews.find((appview: any) => Object.is(appview.viewtag, viewtag));
    if (!appview) {
        console.warn(`视图「${viewtag}」原始数据不存在`);
        return;
    }
    const _appview: any = JSON.parse(JSON.stringify(appview));
    Object.assign(_appview, { secondtag: secondtag, refreshdata: 0 });
    _appview.refviews.forEach((refview: any) => {
        refview = `${refview};${secondtag}`;
    });
    state.createdviews.push(_appview);
}

/**
 * 删除视图
 * 
 * @param state 
 * @param viewtag  视图标识
 */
export const removeView = (state: any, viewtag: string) => {
    const index = state.createdviews.findIndex((view: any) => Object.is(view.secondtag, viewtag));
    if (index === -1) {
        return;
    }
    state.createdviews.splice(index, 1);
}

/**
 * 设置视图数据变化状态
 * 
 * @param state 
 * @param param1 
 */
export const setViewDataChange = (state: any, { viewtag, viewdatachange }: { viewtag: string, viewdatachange: boolean }) => {
    const createdview = state.createdviews.find((appview: any) => Object.is(appview.secondtag, viewtag));
    if (!createdview) {
        console.warn(`设置数据状态变更，视图「${viewtag}」不存在`)
        return;
    }
    createdview.viewdatachange = viewdatachange;
}

/**
 * 刷新视图数据
 * 
 * @param state 
 * @param param1 
 */
export const refreshViewData = (state: any, { viewtag }: { viewtag: string }) => {
    const createdview = state.createdviews.find((appview: any) => Object.is(appview.secondtag, viewtag));
    if (!createdview) {
        console.warn(`刷新视图数据，视图「${viewtag}」不存在`)
        return;
    }
    createdview.refreshdata += 1;
}
