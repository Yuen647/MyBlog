<template>
    <div v-if="categories && categories.length > 0"
        class="w-full p-5 mb-3 bg-gradient-to-br from-white/90 via-gray-50/80 to-white/90 backdrop-blur-sm border border-gray-200 
        rounded-lg shadow-sm hover:shadow-md transition-all duration-500 dark:from-gray-800/90 dark:via-gray-800/80 
        dark:to-gray-800/90 dark:border-gray-700 relative overflow-hidden group">
        <!-- 装饰性背景 -->
        <div class="absolute inset-0 bg-[radial-gradient(circle_at_50%_120%,rgba(99,102,241,0.1),rgba(255,255,255,0))]"></div>
        <div class="absolute inset-0 bg-[url('data:image/svg+xml,%3Csvg width=%2720%27 height=%2720%27 viewBox=%270 0 20 20%27 xmlns=%27http://www.w3.org/2000/svg%27%3E%3Cg fill=%27%23000%27 fill-opacity=%270.025%27 fill-rule=%27evenodd%27%3E%3Ccircle cx=%273%27 cy=%273%27 r=%273%27/%3E%3Ccircle cx=%2713%27 cy=%2713%27 r=%273%27/%3E%3C/g%3E%3C/svg%3E')] opacity-30 dark:opacity-20"></div>
        <div class="absolute inset-0 bg-gradient-to-br from-blue-100/20 via-transparent to-indigo-100/20 dark:from-blue-900/20 dark:to-indigo-900/20 opacity-0 group-hover:opacity-100 transition-opacity duration-500"></div>
        <div class="absolute -inset-1 bg-gradient-to-r from-blue-500 to-indigo-500 rounded-lg blur opacity-0 group-hover:opacity-10 transition duration-500"></div>
        
        <div class="relative">
            <!-- 分类标题 -->
            <div class="flex mb-3">
                <h2 class="flex items-center font-bold text-gray-900 uppercase dark:text-white relative">
                    <!-- 文件夹图标 -->
                    <svg t="1698998570037" class="inline icon w-4 h-4 mr-2 transform transition-transform duration-300 group-hover:rotate-12" viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="21572" width="200" height="200">
                        <path
                            d="M938.666667 464.592593h-853.333334v-265.481482c0-62.577778 51.2-113.777778 113.777778-113.777778h128.948148c15.17037 0 28.444444 3.792593 41.718519 11.377778l98.607407 64.474074h356.503704c62.577778 0 113.777778 51.2 113.777778 113.777778v189.62963z"
                            fill="#3A69DD" p-id="21573"></path>
                        <path
                            d="M805.925926 398.222222h-587.851852v-125.155555c0-24.651852 20.859259-45.511111 45.511111-45.511111h496.82963c24.651852 0 45.511111 20.859259 45.511111 45.511111V398.222222z"
                            fill="#D9E3FF" p-id="21574"></path>
                        <path
                            d="M843.851852 417.185185h-663.703704v-98.607407c0-28.444444 22.755556-53.096296 53.096296-53.096297h559.407408c28.444444 0 53.096296 22.755556 53.096296 53.096297V417.185185z"
                            fill="#FFFFFF" p-id="21575"></path>
                        <path
                            d="M786.962963 938.666667h-549.925926c-83.437037 0-151.703704-68.266667-151.703704-151.703704V341.333333s316.681481 37.925926 430.45926 37.925926c189.62963 0 422.874074-37.925926 422.874074-37.925926v445.62963c0 83.437037-68.266667 151.703704-151.703704 151.703704z"
                            fill="#5F7CF9" p-id="21576"></path>
                        <path
                            d="M559.407407 512h-75.851851c-20.859259 0-37.925926-17.066667-37.925926-37.925926s17.066667-37.925926 37.925926-37.925926h75.851851c20.859259 0 37.925926 17.066667 37.925926 37.925926s-17.066667 37.925926-37.925926 37.925926z"
                            fill="#F9D523" p-id="21577"></path>
                    </svg>
                    <span class="relative">
                        分类
                        <!-- 下划线装饰 -->
                        <span class="absolute -bottom-0.5 left-0 w-0 h-0.5 bg-gradient-to-r from-blue-500 to-indigo-500 group-hover:w-full transition-all duration-300"></span>
                    </span>
                </h2>
                <span class="grow"></span>

                <!-- 查看更多 -->
                <a @click="router.push('/category/list')" 
                    class="relative group/btn bg-gray-100/80 flex items-center px-2.5 py-1 text-xs font-medium text-center 
                    text-gray-900 rounded-lg hover:bg-gray-200/80 focus:ring-4 focus:outline-none focus:ring-gray-200 
                    dark:bg-gray-800/80 dark:text-white dark:border dark:border-gray-700 dark:hover:bg-gray-700/80 
                    dark:hover:border-gray-700 dark:focus:ring-gray-700 transition-all duration-300">
                    <div class="absolute -inset-1 bg-gradient-to-r from-blue-500 to-indigo-500 rounded-lg blur opacity-0 group-hover/btn:opacity-20 transition duration-300"></div>
                    <svg class="w-[7px] h-[7px] text-gray-400 dark:text-white transition-transform duration-300 group-hover/btn:translate-x-0.5" aria-hidden="true"
                        xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 8 14">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="m1 13 5.7-5.326a.909.909 0 0 0 0-1.348L1 1" />
                    </svg>
                </a>
            </div>

            <!-- 分类列表 -->
            <div class="text-sm flex flex-wrap gap-2 font-medium text-gray-600 rounded-lg dark:border-gray-600 dark:text-white">
                <a @click="goCategoryArticleListPage(category.id, category.name)" v-for="(category, index) in categories"
                    :key="index"
                    class="relative group/cat cursor-pointer inline-flex items-center px-3 py-1.5 text-xs font-medium text-center 
                    bg-gradient-to-r from-gray-50/90 to-white/90 border border-gray-200/80 rounded-lg 
                    hover:from-gray-100/90 hover:to-gray-50/90 hover:border-gray-300/80 
                    dark:from-gray-800/90 dark:to-gray-700/90 dark:text-gray-300 dark:border-gray-700/80 
                    dark:hover:from-gray-700/90 dark:hover:to-gray-600/90 dark:hover:border-gray-600/80 transition-all duration-300">
                    <div class="absolute -inset-1 bg-gradient-to-r from-blue-500 to-indigo-500 rounded-lg blur opacity-0 group-hover/cat:opacity-20 transition duration-300"></div>
                    <span class="relative">{{ category.name }}</span>
                    <span class="relative inline-flex items-center justify-center w-4 h-4 ms-2 text-xs font-semibold 
                        text-sky-800 bg-gradient-to-r from-sky-200/90 to-blue-200/90 rounded-full 
                        dark:from-sky-900/90 dark:to-blue-900/90 dark:text-sky-300 
                        transition-transform duration-300 group-hover/cat:scale-110">
                        {{ category.articlesTotal }}
                    </span>
                </a>
            </div>
        </div>
    </div>
</template>

<script setup>
import { getCategoryList } from '@/api/frontend/category'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

// 跳转分类文章列表页
const goCategoryArticleListPage = (id, name) => {
    // 跳转时通过 query 携带参数（分类 ID、分类名称）
    router.push({ path: '/category/article/list', query: { id, name } })
}

// 所有分类
const categories = ref([])
// 一次显示的分类数
const size = ref(10)

getCategoryList({ size: size.value }).then((res) => {
    if (res.success) {
        categories.value = res.data
    }
})
</script>
