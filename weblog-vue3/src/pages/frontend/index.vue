<template>
    <Header></Header>

    <!-- 主内容区域 -->
    <main class="container max-w-screen-xl mx-auto px-4 md:px-6 py-4 min-h-screen bg-gradient-to-br from-gray-50 via-white to-sky-50 dark:from-gray-900 dark:via-gray-800 dark:to-sky-900 relative">
        <!-- 背景装饰 -->
        <div class="absolute inset-0 overflow-hidden pointer-events-none">
            <!-- 主要背景光斑 -->
            <div class="absolute w-96 h-96 -top-48 -left-48 bg-gradient-to-br from-blue-200/40 to-sky-200/40 dark:from-blue-800/40 dark:to-sky-800/40 rounded-full mix-blend-multiply dark:mix-blend-soft-light filter blur-3xl opacity-30 animate-blob"></div>
            <div class="absolute w-96 h-96 -bottom-48 -right-48 bg-gradient-to-br from-purple-200/40 to-pink-200/40 dark:from-purple-800/40 dark:to-pink-800/40 rounded-full mix-blend-multiply dark:mix-blend-soft-light filter blur-3xl opacity-30 animate-blob animation-delay-2000"></div>
            
            <!-- 装饰性光点 -->
            <div class="absolute top-1/4 left-1/4 w-2 h-2 bg-blue-400/30 rounded-full animate-glow-slow"></div>
            <div class="absolute top-3/4 right-1/4 w-2 h-2 bg-purple-400/30 rounded-full animate-glow-slow" style="animation-delay: 2s;"></div>
            <div class="absolute top-1/2 left-3/4 w-1.5 h-1.5 bg-sky-400/30 rounded-full animate-glow-slow" style="animation-delay: 4s;"></div>
            
            <!-- 网格背景 -->
            <div class="absolute inset-0 bg-[url('data:image/svg+xml,%3Csvg width=%2720%27 height=%2720%27 viewBox=%270 0 20 20%27 xmlns=%27http://www.w3.org/2000/svg%27%3E%3Cg fill=%27%23000%27 fill-opacity=%270.015%27 fill-rule=%27evenodd%27%3E%3Ccircle cx=%273%27 cy=%273%27 r=%273%27/%3E%3Ccircle cx=%2713%27 cy=%2713%27 r=%273%27/%3E%3C/g%3E%3C/svg%3E')] opacity-30 dark:opacity-20"></div>
        </div>

        <!-- grid 表格布局，分为 4 列 -->
        <div class="grid grid-cols-4 gap-7 relative">
            <!-- 左边栏，占用 3 列 -->
            <div class="col-span-4 md:col-span-3 mb-3">
                <!-- 文章列表，grid 表格布局，分为 2 列 -->
                <div class="grid grid-cols-2 gap-4">
                    <div v-for="(article, index) in articles" :key="index" 
                        class="col-span-2 md:col-span-1 group perspective-1000 article-card"
                        :style="{ '--delay': `${index * 100}ms` }">
                        <div class="relative bg-white/80 dark:bg-gray-800/80 backdrop-blur-lg transition-all duration-500 
                            group-hover:shadow-[0_0_2rem_-0.5rem_theme(colors.sky.500)] dark:group-hover:shadow-[0_0_2rem_-0.5rem_theme(colors.sky.300)]
                            border border-gray-200/50 dark:border-gray-700/50 rounded-xl h-full transform-gpu 
                            group-hover:-translate-y-1 group-hover:scale-[1.01]">
                            
                            <!-- 文章封面 -->
                            <a @click="goArticleDetailPage(article.id)" class="cursor-pointer block overflow-hidden rounded-t-xl relative group/image">
                                <div class="absolute inset-0 bg-gradient-to-t from-black/60 via-transparent to-transparent opacity-0 group-hover/image:opacity-100 transition-opacity duration-300 z-10"></div>
                                <img class="h-48 w-full object-cover transition-all duration-700 group-hover/image:scale-110 group-hover/image:filter-none filter saturate-[0.9]"
                                    :src="article.cover" />
                            </a>

                            <div class="p-5 flex flex-col min-h-max relative">
                                <!-- 标签 -->
                                <div class="mb-3 flex flex-wrap gap-2">
                                    <span v-for="(tag, tagIndex) in article.tags" :key="tagIndex" 
                                        @click="goTagArticleListPage(tag.id, tag.name)"
                                        class="cursor-pointer relative group/tag">
                                        <div class="absolute -inset-1 bg-gradient-to-r from-green-500 to-emerald-500 rounded-full blur opacity-0 group-hover/tag:opacity-20 transition duration-300"></div>
                                        <span class="relative bg-gradient-to-r from-green-100 to-emerald-100 dark:from-green-900 dark:to-emerald-900
                                            text-green-800 dark:text-green-300 text-xs font-medium px-3 py-1 rounded-full 
                                            transition-all duration-300 hover:shadow-[0_0_1rem_-0.25rem_theme(colors.green.500)]
                                            hover:-translate-y-0.5 hover:scale-105 active:scale-95">
                                            {{ tag.name }}
                                        </span>
                                    </span>
                                </div>

                                <!-- 文章标题 -->
                                <a @click="goArticleDetailPage(article.id)" class="cursor-pointer group/title">
                                    <h2 class="mb-2 text-2xl font-bold tracking-tight text-transparent bg-clip-text bg-gradient-to-r from-gray-900 via-gray-800 to-gray-900 dark:from-white dark:via-gray-100 dark:to-white">
                                        <span class="bg-gradient-to-r from-current to-current bg-[length:0%_2px] 
                                            group-hover/title:bg-[length:100%_2px] bg-no-repeat bg-left-bottom pb-0.5
                                            transition-all duration-500">{{ article.title }}</span>
                                    </h2>
                                </a>

                                <!-- 文章摘要 -->
                                <p v-if="article.summary" 
                                    class="mb-3 font-normal text-gray-500 dark:text-gray-400 line-clamp-2 
                                    transition-all duration-300 group-hover:text-gray-700 dark:group-hover:text-gray-300">
                                    {{ article.summary }}
                                </p>

                                <!-- 文章发布时间、所属分类 -->
                                <p class="mt-auto flex items-center font-normal text-gray-400 text-sm dark:text-gray-500 
                                    transition-all duration-300 group-hover:text-gray-600 dark:group-hover:text-gray-400">
                                    <!-- 发布时间 -->
                                    <svg class="inline w-3.5 h-3.5 mr-2 transition-transform duration-500 group-hover:rotate-[360deg]" 
                                        aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                            stroke-width="2"
                                            d="M5 1v3m5-3v3m5-3v3M1 7h18M5 11h10M2 3h16a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1Z" />
                                    </svg>
                                    {{ article.createDate }}

                                    <!-- 所属分类 -->
                                    <svg class="inline w-3.5 h-3.5 ml-5 mr-2 transition-transform duration-500 group-hover:rotate-[360deg]" 
                                        aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 18">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                            stroke-width="2"
                                            d="M1 5v11a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1H1Zm0 0V2a1 1 0 0 1 1-1h5.443a1 1 0 0 1 .8.4l2.7 3.6H1Z" />
                                    </svg>
                                    <a @click="goCategoryArticleListPage(article.category.id, article.category.name)" 
                                        class="cursor-pointer relative group/cat">
                                        <div class="absolute -inset-1 bg-gradient-to-r from-sky-500 to-blue-500 rounded-lg blur opacity-0 group-hover/cat:opacity-20 transition duration-300"></div>
                                        <span class="relative hover:text-sky-500 transition-all duration-300 
                                            hover:-translate-y-0.5 hover:scale-105">
                                            {{ article.category.name }}
                                        </span>
                                    </a>
                                </p>
                            </div>

                            <!-- 是否置顶 -->
                            <div v-if="article.isTop" 
                                class="absolute inline-flex items-center justify-center w-16 h-8 text-xs font-bold 
                                text-white bg-gradient-to-r from-red-500 via-pink-500 to-purple-500 border-2 
                                border-white rounded-full -top-2 -end-2 dark:border-gray-900 animate-pulse-slow 
                                shadow-lg transform-gpu transition-transform duration-300 hover:scale-110">
                                置顶
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 分页 -->
                <nav aria-label="Page navigation" class="mt-10 flex justify-center">
                    <ul class="flex items-center -space-x-px h-10 text-base">
                        <!-- 上一页 -->
                        <li>
                            <a @click="getArticles(current - 1)"
                                class="flex items-center justify-center px-4 h-10 ml-0 leading-tight text-gray-500 
                                bg-white/80 backdrop-blur-sm border border-gray-300/50 rounded-l-lg 
                                transition-all duration-300 hover:bg-sky-50 hover:text-sky-600 
                                hover:-translate-y-0.5 hover:shadow-[0_0_1rem_-0.25rem_theme(colors.sky.500)]
                                dark:bg-gray-800/80 dark:border-gray-700/50 dark:text-gray-400 
                                dark:hover:bg-sky-900/30 dark:hover:text-sky-400"
                                :class="[current > 1 ? '' : 'cursor-not-allowed opacity-50 pointer-events-none']">
                                <span class="sr-only">上一页</span>
                                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                    viewBox="0 0 6 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="M5 1 1 5l4 4" />
                                </svg>
                            </a>
                        </li>

                        <!-- 页码 -->
                        <li v-for="(pageNo, index) in pages" :key="index">
                            <a @click="getArticles(pageNo)"
                                class="flex items-center justify-center px-4 h-10 leading-tight border backdrop-blur-sm
                                transition-all duration-300 hover:-translate-y-0.5 relative group/page
                                hover:shadow-[0_0_1rem_-0.25rem_theme(colors.sky.500)]
                                dark:border-gray-700/50 dark:text-gray-400 dark:hover:bg-sky-900/30 dark:hover:text-sky-400"
                                :class="[pageNo == current ? 
                                    'text-sky-600 bg-sky-50/80 border-sky-500/50 hover:bg-sky-100/80 hover:text-sky-700' : 
                                    'text-gray-500 border-gray-300/50 bg-white/80 hover:bg-gray-100/80 hover:text-gray-700']">
                                <div class="absolute -inset-1 bg-gradient-to-r from-sky-500 to-blue-500 rounded-lg blur opacity-0 group-hover/page:opacity-20 transition duration-300"></div>
                                <span class="relative">{{ index + 1 }}</span>
                            </a>
                        </li>

                        <!-- 下一页 -->
                        <li>
                            <a @click="getArticles(current + 1)"
                                class="flex items-center justify-center px-4 h-10 leading-tight text-gray-500 
                                bg-white/80 backdrop-blur-sm border border-gray-300/50 rounded-r-lg 
                                transition-all duration-300 hover:bg-sky-50 hover:text-sky-600 
                                hover:-translate-y-0.5 hover:shadow-[0_0_1rem_-0.25rem_theme(colors.sky.500)]
                                dark:bg-gray-800/80 dark:border-gray-700/50 dark:text-gray-400 
                                dark:hover:bg-sky-900/30 dark:hover:text-sky-400"
                                :class="[current < pages ? '' : 'cursor-not-allowed opacity-50 pointer-events-none']">
                                <span class="sr-only">下一页</span>
                                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                    viewBox="0 0 6 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m1 9 4-4-4-4" />
                                </svg>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <!-- 右边侧边栏，占用一列 -->
            <aside class="col-span-4 md:col-span-1 animate__animated animate__fadeInUp">
                <div class="sticky top-[5.5rem] space-y-6">
                    <!-- 博主信息 -->
                    <UserInfoCard></UserInfoCard>

                    <!-- 分类 -->
                    <CategoryListCard></CategoryListCard>

                    <!-- 标签 -->
                    <TagListCard></TagListCard>
                </div>
            </aside>
        </div>
    </main>

    <!-- 返回顶部 -->
    <ScrollToTopButton></ScrollToTopButton>

    <Footer></Footer>
</template>

<script setup>
import Header from '@/layouts/frontend/components/Header.vue'
import Footer from '@/layouts/frontend/components/Footer.vue'
import UserInfoCard from '@/layouts/frontend/components/UserInfoCard.vue'
import CategoryListCard from '@/layouts/frontend/components/CategoryListCard.vue'
import TagListCard from '@/layouts/frontend/components/TagListCard.vue'
import ScrollToTopButton from '@/layouts/frontend/components/ScrollToTopButton.vue'
import { initTooltips } from 'flowbite'
import { onMounted, ref } from 'vue'
import { getArticlePageList } from '@/api/frontend/article'
import { useRouter } from 'vue-router'

const router = useRouter()

// 跳转分类文章列表页
const goCategoryArticleListPage = (id, name) => {
    // 跳转时通过 query 携带参数（分类 ID、分类名称）
    router.push({path: '/category/article/list', query: {id, name}})
}


// initialize components based on data attribute selectors
onMounted(() => {
    initTooltips();
})

// 文章集合
const articles = ref([])
// 当前页码
const current = ref(1)
// 每页显示的文章数
const size = ref(10)
// 总文章数
const total = ref(0)
// 总共多少页
const pages = ref(0)


function getArticles(currentNo) {
    // 上下页是否能点击判断，当要跳转上一页且页码小于 1 时，则不允许跳转；当要跳转下一页且页码大于总页数时，则不允许跳转
    if (currentNo < 1 || (pages.value > 0 && currentNo > pages.value)) return
    // 调用分页接口渲染数据
    getArticlePageList({current: currentNo, size: size.value}).then((res) => {
        if (res.success) {
            articles.value = res.data
            current.value = res.current
            size.value = res.size
            total.value = res.total
            pages.value = res.pages
        }
    })
}
getArticles(current.value)

// 跳转文章详情页
const goArticleDetailPage = (articleId) => {
    router.push('/article/' + articleId)
}

// 跳转标签文章列表页
const goTagArticleListPage = (id, name) => {
    // 跳转时通过 query 携带参数（标签 ID、标签名称）
    router.push({path: '/tag/article/list', query: {id, name}})
}
</script>

<style scoped>
.perspective-1000 {
    perspective: 1000px;
}

.animate-blob {
    animation: blob 7s infinite;
}

.animation-delay-2000 {
    animation-delay: 2s;
}

@keyframes blob {
    0% {
        transform: translate(0px, 0px) scale(1);
    }
    33% {
        transform: translate(30px, -50px) scale(1.1);
    }
    66% {
        transform: translate(-20px, 20px) scale(0.9);
    }
    100% {
        transform: translate(0px, 0px) scale(1);
    }
}

.article-card {
    opacity: 0;
    animation: cardAppear 0.6s ease forwards;
    animation-delay: var(--delay);
}

@keyframes cardAppear {
    0% {
        opacity: 0;
        transform: translateY(10px);
    }
    100% {
        opacity: 1;
        transform: translateY(0);
    }
}

@keyframes glow-slow {
    0%, 100% { 
        opacity: 0.2;
        transform: scale(1);
    }
    50% { 
        opacity: 0.4;
        transform: scale(1.2);
    }
}

.animate-glow-slow {
    animation: glow-slow 6s ease-in-out infinite;
}

@keyframes pulse-slow {
    0%, 100% {
        opacity: 0.6;
    }
    50% {
        opacity: 0.8;
    }
}

.animate-pulse-slow {
    animation: pulse-slow 4s ease-in-out infinite;
}
</style>
