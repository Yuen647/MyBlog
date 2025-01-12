<template>
    <div class="w-full py-5 px-2 mb-3 bg-gradient-to-br from-white/90 via-gray-50/80 to-white/90 backdrop-blur-sm 
        border border-gray-200 rounded-lg shadow-sm hover:shadow-md transition-all duration-500 
        dark:from-gray-800/90 dark:via-gray-800/80 dark:to-gray-800/90 dark:border-gray-700 relative overflow-hidden group">
        <!-- 装饰性背景 -->
        <div class="absolute inset-0 bg-[radial-gradient(circle_at_50%_120%,rgba(147,197,253,0.1),rgba(255,255,255,0))]"></div>
        <div class="absolute inset-0 bg-[url('data:image/svg+xml,%3Csvg width=%2720%27 height=%2720%27 viewBox=%270 0 20 20%27 xmlns=%27http://www.w3.org/2000/svg%27%3E%3Cg fill=%27%23000%27 fill-opacity=%270.025%27 fill-rule=%27evenodd%27%3E%3Ccircle cx=%273%27 cy=%273%27 r=%273%27/%3E%3Ccircle cx=%2713%27 cy=%2713%27 r=%273%27/%3E%3C/g%3E%3C/svg%3E')] opacity-30 dark:opacity-20"></div>
        
        <!-- 动态装饰元素 -->
        <div class="absolute top-10 left-5 w-2 h-2 bg-blue-400/60 rounded-full animate-glow-slow"></div>
        <div class="absolute top-20 right-8 w-1.5 h-1.5 bg-purple-400/60 rounded-full animate-glow-slow" style="animation-delay: 2s;"></div>
        <div class="absolute bottom-12 left-10 w-1 h-1 bg-green-400/60 rounded-full animate-glow-slow" style="animation-delay: 4s;"></div>
        
        <!-- 几何装饰 -->
        <div class="absolute -top-6 -left-6 w-12 h-12 bg-gradient-to-br from-blue-500/20 to-sky-500/20 rounded-full blur-xl animate-pulse-slow"></div>
        <div class="absolute -bottom-6 -right-6 w-12 h-12 bg-gradient-to-br from-purple-500/20 to-pink-500/20 rounded-full blur-xl animate-pulse-slow" style="animation-delay: 3s;"></div>
        
        <!-- 悬浮渐变效果 -->
        <div class="absolute inset-0 bg-gradient-to-br from-blue-100/20 via-transparent to-sky-100/20 dark:from-blue-900/20 dark:to-sky-900/20 opacity-0 group-hover:opacity-100 transition-opacity duration-500"></div>
        <div class="absolute -inset-1 bg-gradient-to-r from-blue-500 to-sky-500 rounded-lg blur opacity-0 group-hover:opacity-10 transition duration-500"></div>
        
        <!-- 装饰线条 -->
        <div class="absolute top-0 left-0 w-full h-px bg-gradient-to-r from-transparent via-blue-500/50 to-transparent"></div>
        <div class="absolute bottom-0 left-0 w-full h-px bg-gradient-to-r from-transparent via-sky-500/50 to-transparent"></div>
        
        <div class="flex flex-col items-center relative">
            <!-- 博主头像 -->
            <div class="relative mb-4 group/avatar">
                <div class="absolute -inset-1 bg-gradient-to-r from-blue-500 to-sky-500 rounded-full blur opacity-0 group-hover/avatar:opacity-50 transition duration-300"></div>
                <img class="relative w-14 h-14 rounded-full shadow-lg ring-2 ring-gray-200/50 dark:ring-gray-700/50 transform transition-all duration-300 group-hover/avatar:scale-105"
                    :src="blogSettingsStore.blogSettings.avatar"/>    
                <span class="bottom-0 left-10 absolute w-3.5 h-3.5 bg-gradient-to-br from-green-400 to-emerald-400 
                    border-2 border-white dark:border-gray-800 rounded-full animate-pulse"></span>
            </div>
            
            <!-- 博主昵称 -->
            <h5 class="mb-2 text-xl font-medium text-transparent bg-clip-text bg-gradient-to-r from-gray-900 via-blue-600 to-gray-600 
                dark:from-white dark:via-blue-400 dark:to-gray-300 group-hover:scale-105 transition-transform duration-300">
                {{ blogSettingsStore.blogSettings.author }}
            </h5>
            
            <!-- 介绍语 -->
            <span class="mb-6 text-sm text-gray-500 dark:text-gray-400 group-hover:text-gray-600 dark:group-hover:text-gray-300 
                transition-colors duration-300 relative" data-tooltip-target="introduction-tooltip-bottom" data-tooltip-placement="bottom">
                <span class="relative">
                    {{ blogSettingsStore.blogSettings.introduction }}
                    <span class="absolute -bottom-1 left-0 w-0 h-0.5 bg-gradient-to-r from-blue-500 to-sky-500 group-hover:w-full transition-all duration-500"></span>
                </span>
            </span>
            <div id="introduction-tooltip-bottom" role="tooltip"
                class="absolute z-10 invisible inline-block px-3 py-2 text-xs font-medium text-white bg-gray-900 rounded shadow-sm opacity-0 tooltip dark:bg-gray-700">
                介绍语
                <div class="tooltip-arrow" data-popper-arrow></div>
            </div>

            <!-- 文章数量、分类数量、标签数量、总访问量 -->
            <div class="flex justify-center gap-5 mb-2 dark:text-gray-400">
                <div class="flex items-center flex-col gap-1 hover:text-sky-600 hover:scale-110 cursor-pointer transition-all duration-300 relative group/stat">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-lg blur opacity-0 group-hover/stat:opacity-20 transition duration-300"></div>
                    <CountTo :value="statisticsInfo.articleTotalCount" customClass="text-lg font-bold relative"></CountTo>
                    <div class="text-sm relative">文章</div>
                </div>
                <div class="flex items-center flex-col gap-1 hover:text-sky-600 hover:scale-110 cursor-pointer transition-all duration-300 relative group/stat">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-lg blur opacity-0 group-hover/stat:opacity-20 transition duration-300"></div>
                    <CountTo :value="statisticsInfo.categoryTotalCount" customClass="text-lg font-bold relative"></CountTo>
                    <div class="text-sm relative">分类</div>
                </div>
                <div class="flex items-center flex-col gap-1 hover:text-sky-600 hover:scale-110 cursor-pointer transition-all duration-300 relative group/stat">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-lg blur opacity-0 group-hover/stat:opacity-20 transition duration-300"></div>
                    <CountTo :value="statisticsInfo.tagTotalCount" customClass="text-lg font-bold relative"></CountTo>
                    <div class="text-sm relative">标签</div>
                </div>
                <div class="flex items-center flex-col gap-1 hover:text-sky-600 hover:scale-110 cursor-pointer transition-all duration-300 relative group/stat">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-lg blur opacity-0 group-hover/stat:opacity-20 transition duration-300"></div>
                    <CountTo :value="statisticsInfo.pvTotalCount" customClass="text-lg font-bold relative"></CountTo>
                    <div class="text-sm relative">总访问量</div>
                </div>
            </div>

            <!-- 第三方平台主页跳转 -->
            <div class="flex justify-center gap-2 relative">
                <!-- 装饰线条 -->
                <div class="absolute -top-2 left-0 w-full h-px bg-gradient-to-r from-transparent via-blue-500/30 to-transparent"></div>
                
                <!-- GitHub -->
                <div class="relative group/icon" v-if="blogSettingsStore.blogSettings.githubHomepage">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-full blur opacity-0 group-hover/icon:opacity-30 transition duration-300"></div>
                    <svg @click="jump(blogSettingsStore.blogSettings.githubHomepage)" t="1698029949662" data-tooltip-target="github-tooltip-bottom" data-tooltip-placement="bottom"
                        class="relative hover:scale-110 icon mt-5 w-7 h-7 transition-transform duration-300" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                        p-id="1447" width="200" height="200">
                        <path d="M512 512m-512 0a512 512 0 1 0 1024 0 512 512 0 1 0-1024 0Z" fill="#4186F5" p-id="1448"></path>
                        <path
                            d="M611.944 302.056c0-15.701 2.75-30.802 7.816-44.917a384.238 384.238 0 0 0-186.11 2.956c-74.501-50.063-93.407-71.902-107.975-39.618a136.243 136.243 0 0 0-3.961 102.287 149.515 149.515 0 0 0-39.949 104.806c0 148.743 92.139 181.875 179.961 191.61a83.898 83.898 0 0 0-25.192 51.863c-40.708 22.518-91.94 8.261-115.181-32.058a83.117 83.117 0 0 0-60.466-39.98s-38.871-0.361-2.879 23.408a102.97 102.97 0 0 1 43.912 56.906s23.398 75.279 133.531 51.863v65.913c0 10.443 13.548 42.63 102.328 42.63 71.275 0 94.913-30.385 94.913-42.987V690.485a90.052 90.052 0 0 0-26.996-72.03c83.996-9.381 173.328-40.204 179.6-176.098a164.706 164.706 0 0 1-21.129 1.365c-84.07 0-152.223-63.426-152.223-141.666z"
                            fill="#FFFFFF" p-id="1449"></path>
                        <path
                            d="M743.554 322.765a136.267 136.267 0 0 0-3.961-102.289s-32.396-10.445-107.979 39.618a385.536 385.536 0 0 0-11.853-2.956 132.623 132.623 0 0 0-7.816 44.917c0 78.24 68.152 141.667 152.222 141.667 7.171 0 14.222-0.472 21.129-1.365 0.231-5.03 0.363-10.187 0.363-15.509a149.534 149.534 0 0 0-42.105-104.083z"
                            fill="#FFFFFF" opacity=".4" p-id="1450"></path>
                    </svg>
                </div>
                <div id="github-tooltip-bottom" role="tooltip"
                    class="absolute z-10 invisible inline-block px-3 py-2 text-xs font-medium text-white bg-gray-900 rounded shadow-sm opacity-0 tooltip dark:bg-gray-700">
                    我的 GitHub
                    <div class="tooltip-arrow" data-popper-arrow></div>
                </div>
                
                <!-- Gitee -->
                <div class="relative group/icon" v-if="blogSettingsStore.blogSettings.giteeHomepage">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-full blur opacity-0 group-hover/icon:opacity-30 transition duration-300"></div>
                    <svg @click="jump(blogSettingsStore.blogSettings.giteeHomepage)" t="1698030969736" data-tooltip-target="gitee-tooltip-bottom" data-tooltip-placement="bottom"
                        class="relative hover:scale-110 icon mt-5 w-7 h-7 transition-transform duration-300" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                        p-id="2438" width="200" height="200">
                        <path
                            d="M512 1024C229.2224 1024 0 794.7776 0 512 0 229.2224 229.2224 0 512 0s512 229.2224 512 512-229.2224 512-512 512z m259.149-568.883h-290.74a25.293 25.293 0 0 0-25.292 25.293l-0.026 63.206c0 13.952 11.315 25.293 25.267 25.293h177.024c13.978 0 25.293 11.315 25.293 25.267v12.646a75.853 75.853 0 0 1-75.853 75.853h-240.23a25.293 25.293 0 0 1-25.267-25.293V417.203a75.853 75.853 0 0 1 75.827-75.853h353.946a25.293 25.293 0 0 0 25.267-25.292l0.077-63.207a25.293 25.293 0 0 0-25.268-25.293H417.152a189.62 189.62 0 0 0-189.62 189.645V771.15c0 13.977 11.316 25.293 25.294 25.293h372.94a170.65 170.65 0 0 0 170.65-170.65V480.384a25.293 25.293 0 0 0-25.293-25.267z"
                            fill="#C71D23" p-id="2439"></path>
                    </svg>
                </div>
                <div id="gitee-tooltip-bottom" role="tooltip"
                    class="absolute z-10 invisible inline-block px-3 py-2 text-xs font-medium text-white bg-gray-900 rounded shadow-sm opacity-0 tooltip dark:bg-gray-700">
                    我的 Gitee
                    <div class="tooltip-arrow" data-popper-arrow></div>
                </div>
                
                <!-- 知乎 -->
                <div class="relative group/icon" v-if="blogSettingsStore.blogSettings.zhihuHomepage">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-full blur opacity-0 group-hover/icon:opacity-30 transition duration-300"></div>
                    <svg @click="jump(blogSettingsStore.blogSettings.zhihuHomepage)" t="1698031258903" data-tooltip-target="zhihu-tooltip-bottom" data-tooltip-placement="bottom"
                        class="relative hover:scale-110 icon mt-5 w-7 h-7 transition-transform duration-300" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                        p-id="3419" width="200" height="200">
                        <path d="M512 512m-512 0a512 512 0 1 0 1024 0 512 512 0 1 0-1024 0Z" fill="#FFFFFF" p-id="3420"></path>
                        <path
                            d="M512 1024A512 512 0 1 1 512 0a512 512 0 0 1 0 1024zM382.08 267.52s-36.16 2.112-48.96 24.512c-12.8 22.336-54.272 137.344-54.272 137.344s13.824 6.4 37.248-10.624c23.424-17.088 30.912-46.848 30.912-46.848l42.56-2.176 1.088 121.408s-73.472-1.088-88.384 0c-14.912 1.088-23.424 40.448-23.424 40.448h111.808s-9.6 67.136-38.4 116.096c-28.672 49.024-83.008 87.296-83.008 87.296s39.424 16 77.696-6.4c38.4-22.336 66.688-120.64 66.688-120.64l89.92 110.08s8.192-52.48-1.472-67.2c-9.664-14.848-62.208-74.304-62.208-74.304l-22.976 20.224 16.32-65.088H531.2s0-38.4-19.2-40.512c-19.136-2.112-78.72 0-78.72 0V371.84h88.32s-1.024-39.424-18.048-39.424H359.68l22.4-64.96z m170.048 61.184v358.592h35.968l13.12 44.992 63.36-45.056h89.088V328.704h-201.6z"
                            fill="#0F84FD" p-id="3421"></path>
                        <path d="M594.752 368.64h117.952v277.888h-41.92l-53.376 40.256-11.648-40.32h-11.008V368.64z"
                            fill="#0F84FD" p-id="3422"></path>
                    </svg>
                </div>
                <div id="zhihu-tooltip-bottom" role="tooltip"
                    class="absolute z-10 invisible inline-block px-3 py-2 text-xs rounded font-medium text-white bg-gray-900 shadow-sm opacity-0 tooltip dark:bg-gray-700">
                    我的知乎
                    <div class="tooltip-arrow" data-popper-arrow></div>
                </div>
                
                <!-- CSDN -->
                <div class="relative group/icon" v-if="blogSettingsStore.blogSettings.csdnHomepage">
                    <div class="absolute -inset-2 bg-gradient-to-r from-blue-500 to-sky-500 rounded-full blur opacity-0 group-hover/icon:opacity-30 transition duration-300"></div>
                    <svg @click="jump(blogSettingsStore.blogSettings.csdnHomepage)" t="1698031311586" data-tooltip-target="csdn-tooltip-bottom" data-tooltip-placement="bottom"
                        class="relative hover:scale-110 icon mt-5 w-7 h-7 transition-transform duration-300" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                        p-id="4386" width="200" height="200">
                        <path
                            d="M512 1024C229.2224 1024 0 794.7776 0 512 0 229.2224 229.2224 0 512 0c282.7776 0 512 229.2224 512 512 0 282.7776-229.2224 512-512 512z m17.066667-413.525333c34.850133 4.352 68.778667 5.12 102.741333 2.0992 23.04-2.048 44.817067-8.362667 64.170667-21.9136 38.212267-26.794667 49.783467-85.1968 24.251733-123.050667-14.626133-21.7088-36.8128-30.344533-60.757333-35.498667-35.054933-7.543467-70.4512-5.751467-105.847467-3.413333-5.666133 0.3584-6.7584 3.072-7.236267 8.209067-3.072 32.682667-6.536533 65.314133-9.813333 97.962666-2.5088 24.814933-4.932267 49.629867-7.509333 75.605334z m53.4016-33.928534c1.962667-20.906667 3.6352-39.338667 5.4272-57.770666 1.553067-15.906133 3.413333-31.778133 4.727466-47.701334 0.3584-4.283733 1.553067-6.656 5.956267-6.382933 15.616 1.041067 31.709867 0.034133 46.728533 3.652267 36.488533 8.823467 48.725333 54.306133 23.3472 83.029333-15.8208 17.902933-36.7616 23.586133-59.255466 25.088-8.465067 0.546133-17.015467 0.085333-26.9312 0.085333zM512 434.295467c-2.184533-0.648533-3.5328-1.1776-4.932267-1.4336-37.717333-6.877867-75.690667-8.328533-113.646933-2.816-20.974933 3.037867-41.0112 9.489067-57.480533 23.330133-22.9888 19.319467-21.640533 46.848 4.4032 62.0032 13.056 7.594667 28.023467 12.509867 42.5984 17.288533 14.08 4.608 28.996267 6.826667 43.144533 11.264 12.5952 3.925333 14.011733 14.318933 3.584 22.306134-3.345067 2.56-7.441067 5.085867-11.537067 5.751466-11.195733 1.826133-22.698667 4.386133-33.826133 3.566934-24.098133-1.774933-48.042667-5.461333-72.5504-8.430934-1.365333 10.615467-2.935467 23.0912-4.5568 35.9424 4.181333 1.365333 7.68 2.730667 11.264 3.618134 33.9456 8.4992 68.386133 9.608533 102.912 5.12 20.087467-2.6112 39.4752-7.901867 56.695467-19.029334 28.603733-18.4832 36.693333-57.1904-4.676267-75.383466-14.506667-6.382933-30.190933-10.410667-45.482667-15.086934-11.4176-3.4816-23.313067-5.614933-34.525866-9.5232-9.7792-3.413333-11.144533-12.202667-3.037867-18.397866 4.6592-3.549867 10.717867-6.997333 16.384-7.3728a480.853333 480.853333 0 0 1 53.384533-0.853334c15.377067 0.699733 30.651733 3.549867 46.4896 5.5296L512 434.295467z m257.143467 2.048L750.933333 614.2976h54.152534c4.778667-45.636267 9.710933-90.7264 14.062933-135.8848 0.6144-6.365867 2.3552-8.840533 8.686933-9.0112 11.434667-0.273067 22.8864-1.979733 34.286934-1.570133 23.722667 0.853333 42.3936 9.728 38.4 43.264-2.901333 24.2688-5.597867 48.571733-8.2432 72.874666-1.092267 10.069333-1.826133 20.189867-2.730667 30.4128h55.330133c3.584-35.259733 7.9872-70.058667 10.496-104.994133 3.413333-47.4624-17.7664-73.3184-64.682666-80.213333-40.96-6.007467-81.339733-0.341333-121.5488 7.133866z m-483.498667 134.6048c-8.738133 1.297067-16.384 2.798933-24.098133 3.4816-25.6512 2.235733-51.319467 3.9424-76.305067-4.266667-13.909333-4.590933-24.6784-12.578133-29.7984-25.9584-7.901867-20.701867 0.887467-47.104 19.831467-60.3136 17.373867-12.117333 37.717333-15.9232 58.453333-15.9232 22.545067-0.017067 45.090133 2.423467 68.232533 3.84L307.2 432.298667c-15.069867-1.723733-29.4912-3.925333-43.997867-4.9152-41.0112-2.798933-80.64 2.6112-117.469866 20.462933-30.020267 14.557867-52.053333 36.010667-58.6752 68.130133-7.850667 38.144 11.537067 69.495467 51.7632 85.845334 19.1488 7.765333 39.287467 12.509867 60.0064 12.5952 24.746667 0.1024 49.493333-1.570133 74.205866-2.952534 3.106133-0.170667 8.311467-2.901333 8.669867-5.034666 1.979733-11.554133 2.730667-23.278933 3.9424-35.464534z"
                            fill="#DD1700" p-id="4387"></path>
                    </svg>
                </div>
                <div id="csdn-tooltip-bottom" role="tooltip"
                    class="absolute z-10 invisible inline-block px-3 py-2 text-xs rounded font-medium text-white bg-gray-900 shadow-sm opacity-0 tooltip dark:bg-gray-700">
                    我的 CSDN
                    <div class="tooltip-arrow" data-popper-arrow></div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useBlogSettingsStore } from '@/stores/blogsettings'
import { initTooltips } from 'flowbite'
import { onMounted, ref } from 'vue'
import { getStatisticsInfo } from '@/api/frontend/statistics'
import CountTo from '@/components/CountTo.vue'

// 初始化 Flowbit 组件
onMounted(() => {
    initTooltips();
})

// 引入博客设置信息 store
const blogSettingsStore = useBlogSettingsStore()

const jump = (url) => {
    // 在新窗口访问新的链接地址
    window.open(url, '_blank');
} 

// 统计信息(文章、分类、标签数量、总访问量)
const statisticsInfo = ref({})
getStatisticsInfo().then(res => {
    if (res.success) {
        statisticsInfo.value = res.data
    }
})
</script>

<style scoped>
@keyframes glow-slow {
    0%, 100% { 
        opacity: 0.4;
        transform: scale(1);
    }
    50% { 
        opacity: 0.8;
        transform: scale(1.1);
    }
}

@keyframes pulse-slow {
    0%, 100% {
        opacity: 0.3;
    }
    50% {
        opacity: 0.6;
    }
}

.animate-glow-slow {
    animation: glow-slow 4s ease-in-out infinite;
}

.animate-pulse-slow {
    animation: pulse-slow 6s ease-in-out infinite;
}
</style>
