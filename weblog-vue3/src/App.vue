<template>
   <!-- 设置语言为中文 -->
   <el-config-provider :locale="locale">
      <!-- 添加背景装饰容器 -->
      <div class="min-h-screen bg-gradient-to-br from-blue-100 via-sky-100 to-indigo-100 dark:from-slate-800 dark:via-blue-900 dark:to-slate-900 relative overflow-hidden">
         <!-- 背景装饰 -->
         <div class="fixed inset-0 overflow-hidden pointer-events-none" style="z-index: 0;">
            <!-- 主要背景光斑 -->
            <div class="absolute w-[1200px] h-[1200px] -top-[600px] -left-[600px] bg-gradient-to-br from-blue-400/20 to-cyan-400/20 dark:from-blue-500/10 dark:to-cyan-500/10 rounded-full mix-blend-soft-light filter blur-3xl"></div>
            <div class="absolute w-[1200px] h-[1200px] -bottom-[600px] -right-[600px] bg-gradient-to-br from-sky-400/20 to-indigo-400/20 dark:from-sky-500/10 dark:to-indigo-500/10 rounded-full mix-blend-soft-light filter blur-3xl"></div>
            
            <!-- 粒子容器 -->
            <div class="particles-container">
               <div v-for="n in 150" :key="n" 
                    :class="[
                      'particle',
                      `particle-${Math.floor(Math.random() * 5)}`
                    ]"
                    :style="{
                        '--x': `${Math.random() * 100}%`,
                        '--y': `${Math.random() * 100}%`,
                        '--duration': `${20 + Math.random() * 40}s`,
                        '--delay': `${-Math.random() * 40}s`,
                        '--size': `${2 + Math.random() * 5}px`,
                        '--glow': `${Math.random() * 4 + 3}px`,
                        '--opacity': Math.random() * 0.4 + 0.2
                    }">
               </div>
            </div>
            
            <!-- 连线效果 -->
            <div class="line-container">
               <div v-for="n in 30" :key="n"
                    :class="[
                      'connection-line',
                      `line-${Math.floor(Math.random() * 5)}`
                    ]"
                    :style="{
                        '--start-x': `${Math.random() * 100}%`,
                        '--start-y': `${Math.random() * 100}%`,
                        '--width': `${150 + Math.random() * 250}px`,
                        '--angle': `${Math.random() * 360}deg`,
                        '--duration': `${25 + Math.random() * 25}s`,
                        '--delay': `${-Math.random() * 25}s`
                    }">
               </div>
            </div>
         </div>
         
         <!-- 主要内容区域，确保在背景之上 -->
         <div class="relative" style="z-index: 1;">
            <router-view></router-view>
         </div>
      </div>
   </el-config-provider>
</template>

<script setup>
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
const locale = zhCn

console.log(import.meta.env)
</script>

<style>
/* 自定义顶部加载 Loading 颜色 */
#nprogress .bar {
   background: #409eff!important;
   z-index: 2000;
}

/* 暗黑模式 body 背景色 */
.dark body {
   --tw-bg-opacity: 1;
    background-color: rgb(17 24 39 / var(--tw-bg-opacity));
}

/* 粒子容器 */
.particles-container {
    position: absolute;
    inset: 0;
    overflow: hidden;
}

/* 粒子基础样式 */
.particle {
    position: absolute;
    left: var(--x);
    top: var(--y);
    width: var(--size);
    height: var(--size);
    border-radius: 50%;
    animation: particle-movement var(--duration) ease-in-out infinite;
    animation-delay: var(--delay);
    opacity: var(--opacity);
    will-change: transform;
    mix-blend-mode: plus-lighter;
}

/* 粒子颜色变体 - 适中的颜色 */
.particle-0 {
    background: #F87171;
    box-shadow: 0 0 var(--glow) #F87171;
}

.particle-1 {
    background: #FBBF24;
    box-shadow: 0 0 var(--glow) #FBBF24;
}

.particle-2 {
    background: #60A5FA;
    box-shadow: 0 0 var(--glow) #60A5FA;
}

.particle-3 {
    background: #34D399;
    box-shadow: 0 0 var(--glow) #34D399;
}

.particle-4 {
    background: #A78BFA;
    box-shadow: 0 0 var(--glow) #A78BFA;
}

/* 暗黑模式粒子颜色 */
.dark .particle-0 {
    background: #EF4444;
    box-shadow: 0 0 var(--glow) #EF4444;
}

.dark .particle-1 {
    background: #F59E0B;
    box-shadow: 0 0 var(--glow) #F59E0B;
}

.dark .particle-2 {
    background: #3B82F6;
    box-shadow: 0 0 var(--glow) #3B82F6;
}

.dark .particle-3 {
    background: #10B981;
    box-shadow: 0 0 var(--glow) #10B981;
}

.dark .particle-4 {
    background: #8B5CF6;
    box-shadow: 0 0 var(--glow) #8B5CF6;
}

/* 连线效果 */
.line-container {
    position: absolute;
    inset: 0;
    overflow: hidden;
}

.connection-line {
    position: absolute;
    left: var(--start-x);
    top: var(--start-y);
    width: var(--width);
    height: 1.5px;
    transform-origin: left center;
    transform: rotate(var(--angle));
    animation: line-movement var(--duration) ease-in-out infinite;
    animation-delay: var(--delay);
    will-change: transform, opacity;
    mix-blend-mode: plus-lighter;
}

/* 连线颜色变体 */
.line-0 {
    background: linear-gradient(90deg, transparent, rgba(248, 113, 113, 0.3), transparent);
}

.line-1 {
    background: linear-gradient(90deg, transparent, rgba(251, 191, 36, 0.3), transparent);
}

.line-2 {
    background: linear-gradient(90deg, transparent, rgba(96, 165, 250, 0.3), transparent);
}

.line-3 {
    background: linear-gradient(90deg, transparent, rgba(52, 211, 153, 0.3), transparent);
}

.line-4 {
    background: linear-gradient(90deg, transparent, rgba(167, 139, 250, 0.3), transparent);
}

/* 暗黑模式连线颜色 */
.dark .line-0 {
    background: linear-gradient(90deg, transparent, rgba(239, 68, 68, 0.3), transparent);
}

.dark .line-1 {
    background: linear-gradient(90deg, transparent, rgba(245, 158, 11, 0.3), transparent);
}

.dark .line-2 {
    background: linear-gradient(90deg, transparent, rgba(59, 130, 246, 0.3), transparent);
}

.dark .line-3 {
    background: linear-gradient(90deg, transparent, rgba(16, 185, 129, 0.3), transparent);
}

.dark .line-4 {
    background: linear-gradient(90deg, transparent, rgba(139, 92, 246, 0.3), transparent);
}

/* 粒子移动动画 */
@keyframes particle-movement {
    0% {
        transform: translate(0, 0) scale(1);
    }
    25% {
        transform: translate(300px, 150px) scale(1.2);
    }
    50% {
        transform: translate(150px, 300px) scale(0.8);
    }
    75% {
        transform: translate(-150px, 150px) scale(1.2);
    }
    100% {
        transform: translate(0, 0) scale(1);
    }
}

/* 连线移动动画 */
@keyframes line-movement {
    0% {
        transform: rotate(var(--angle)) translateX(-50%);
        opacity: 0;
    }
    25% {
        opacity: 1;
    }
    75% {
        opacity: 1;
    }
    100% {
        transform: rotate(var(--angle)) translateX(150%);
        opacity: 0;
    }
}

/* 添加模糊效果使粒子看起来更柔和 */
.particles-container::after,
.line-container::after {
    content: '';
    position: absolute;
    inset: 0;
    backdrop-filter: blur(0.5px);
}
</style>

