export function Errorlog(target: Object, propertyKey: string, descriptor: TypedPropertyDescriptor<any>){
    let origin=descriptor.value;
    descriptor.value=function(...args:any[]){
      return new Promise((resolve: any, reject: any) => {
          // 原方法调用方法
          let result=origin.apply(this,args); 
          result.then((res:any)=>{
              resolve(res);
          }).catch((error:any)=>{
              // 开发模式下页面报错
              if (process.env.NODE_ENV === 'development') {
                console.error(target.constructor.name+'类'+propertyKey+'方法产生异常');
              }
              // 控制台报错
              console.error(error); 
              reject(error);
          })
      });
    };
    return descriptor;
}