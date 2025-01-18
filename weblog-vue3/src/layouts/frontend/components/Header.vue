<template>
    <header class="sticky top-0 z-10">
        <!-- 装饰性背景元素 -->
        <div class="absolute inset-0 overflow-hidden">
            <!-- 主背景渐变 -->
            <div class="absolute inset-0 bg-gradient-to-b from-white/90 via-white/80 to-transparent dark:from-gray-900/90 dark:via-gray-900/80 dark:to-transparent backdrop-blur-md"></div>
            
            <!-- 动态光斑效果 -->
            <div class="absolute inset-0">
                <div class="absolute -left-4 -top-4 w-24 h-24 bg-sky-500/20 rounded-full mix-blend-multiply filter blur-xl animate-blob"></div>
                <div class="absolute -right-4 -top-4 w-24 h-24 bg-purple-500/20 rounded-full mix-blend-multiply filter blur-xl animate-blob animation-delay-2000"></div>
                <div class="absolute left-1/4 -top-4 w-24 h-24 bg-pink-500/20 rounded-full mix-blend-multiply filter blur-xl animate-blob animation-delay-4000"></div>
                
                <!-- 新增的装饰元素 -->
                <div class="absolute right-1/4 -top-8 w-32 h-32 bg-emerald-500/10 rounded-full mix-blend-multiply filter blur-xl animate-blob-reverse animation-delay-3000"></div>
                <div class="absolute left-1/3 -top-6 w-16 h-16 bg-yellow-500/10 rounded-full mix-blend-multiply filter blur-lg animate-pulse-slow"></div>
            </div>
            
            <!-- 几何装饰 -->
            <div class="absolute inset-0">
                <!-- 左上角装饰 -->
                <div class="absolute -left-8 -top-8 w-32 h-32 rotate-45 border border-sky-500/20 dark:border-sky-400/20 rounded-3xl animate-spin-slower"></div>
                <!-- 右上角装饰 -->
                <div class="absolute -right-8 -top-8 w-32 h-32 -rotate-12 border border-purple-500/20 dark:border-purple-400/20 rounded-3xl animate-float"></div>
            </div>

            <!-- 网格背景 -->
            <div class="absolute inset-0">
                <div class="absolute inset-0 bg-[url('data:image/svg+xml,%3Csvg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 32 32%22 width=%2232%22 height=%2232%22 fill=%22none%22 stroke=%22rgb(15 23 42 / 0.04)%22%3E%3Cpath d=%22M0 .5H31.5V32%22/%3E%3C/svg%3E')] dark:bg-[url('data:image/svg+xml,%3Csvg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 32 32%22 width=%2232%22 height=%2232%22 fill=%22none%22 stroke=%22rgb(148 163 184 / 0.05)%22%3E%3Cpath d=%22M0 .5H31.5V32%22/%3E%3C/svg%3E')] opacity-30"></div>
                <div class="absolute inset-0 bg-gradient-to-b from-transparent via-white/5 to-white/10 dark:from-transparent dark:via-gray-800/5 dark:to-gray-800/10 backdrop-blur-[1px]"></div>
            </div>
        </div>
        
        <nav class="relative border-b border-gray-200/80 dark:border-gray-800/80">
            <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                <!-- 博客 LOGO 、博客名称 -->
                <a href="/" class="flex items-center group relative">
                    <!-- Logo 光晕效果 -->
                    <div class="absolute -inset-1 bg-gradient-to-r from-sky-600 to-sky-400 rounded-full blur opacity-0 group-hover:opacity-20 transition duration-500"></div>
                    <!-- Logo 外环动画 -->
                    <div class="absolute -inset-1 rounded-full border-2 border-sky-500/30 opacity-0 group-hover:opacity-100 group-hover:animate-spin-slow transition-opacity duration-500"></div>
                    
                    <img :src="blogSettingsStore.blogSettings.logo" class="relative h-8 mr-3 rounded-full transition-all duration-300 group-hover:scale-110 group-hover:shadow-lg group-hover:shadow-sky-500/50" alt="Weblog Logo" />
                    <span class="relative self-center text-2xl font-semibold whitespace-nowrap bg-gradient-to-r from-gray-900 via-gray-800 to-gray-600 dark:from-white dark:via-gray-200 dark:to-gray-300 bg-clip-text text-transparent group-hover:from-sky-600 group-hover:via-sky-500 group-hover:to-sky-400 transition-all duration-500">{{
                        blogSettingsStore.blogSettings.name }}</span>
                </a>

                <div class="flex items-center md:order-2 space-x-3">
                    <!-- 移动端搜索按钮 -->
                    <button type="button" data-collapse-toggle="navbar-search" aria-controls="navbar-search"
                        aria-expanded="false"
                        class="md:hidden relative overflow-hidden text-gray-500 hover:text-gray-900 dark:text-gray-400 dark:hover:text-white rounded-lg text-sm p-2.5 mr-1 transition-all duration-300 hover:bg-gray-100/50 dark:hover:bg-gray-700/50 focus:outline-none focus:ring-2 focus:ring-sky-500/50">
                        <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                            viewBox="0 0 20 20">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                        </svg>
                    </button>

                    <!-- 白天黑夜切换 -->
                    <button @click="toggleDark()" class="relative ml-1 mr-4 vt-switch vt-switch-appearance group" type="button" role="switch" 
                        aria-label="切换深色模式" aria-checked="false">
                        <div class="absolute -inset-1 bg-gradient-to-r from-sky-600 to-sky-400 rounded-full blur opacity-0 group-hover:opacity-20 transition duration-500"></div>
                        <span class="vt-switch-check">
                            <span class="vt-switch-icon">
                                <!-- 太阳图标 -->
                                <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true"
                                    focusable="false" viewBox="0 0 24 24" class="vt-switch-appearance-sun"
                                    :class="[isDark ? 'hidden' : 'block']">
                                    <path d="M12,18c-3.3,0-6-2.7-6-6s2.7-6,6-6s6,2.7,6,6S15.3,18,12,18zM12,8c-2.2,0-4,1.8-4,4c0,2.2,1.8,4,4,4c2.2,0,4-1.8,4-4C16,9.8,14.2,8,12,8z"></path>
                                    <path d="M12,4c-0.6,0-1-0.4-1-1V1c0-0.6,0.4-1,1-1s1,0.4,1,1v2C13,3.6,12.6,4,12,4z"></path>
                                    <path d="M12,24c-0.6,0-1-0.4-1-1v-2c0-0.6,0.4-1,1-1s1,0.4,1,1v2C13,23.6,12.6,24,12,24z"></path>
                                    <path d="M5.6,6.6c-0.3,0-0.5-0.1-0.7-0.3L3.5,4.9c-0.4-0.4-0.4-1,0-1.4s1-0.4,1.4,0l1.4,1.4c0.4,0.4,0.4,1,0,1.4C6.2,6.5,5.9,6.6,5.6,6.6z"></path>
                                    <path d="M19.8,20.8c-0.3,0-0.5-0.1-0.7-0.3l-1.4-1.4c-0.4-0.4-0.4-1,0-1.4s1-0.4,1.4,0l1.4,1.4c0.4,0.4,0.4,1,0,1.4C20.3,20.7,20,20.8,19.8,20.8z"></path>
                                    <path d="M3,13H1c-0.6,0-1-0.4-1-1s0.4-1,1-1h2c0.6,0,1,0.4,1,1S3.6,13,3,13z"></path>
                                    <path d="M23,13h-2c-0.6,0-1-0.4-1-1s0.4-1,1-1h2c0.6,0,1,0.4,1,1S23.6,13,23,13z"></path>
                                    <path d="M4.2,20.8c-0.3,0-0.5-0.1-0.7-0.3c-0.4-0.4-0.4-1,0-1.4l1.4-1.4c0.4-0.4,1-0.4,1.4,0s0.4,1,0,1.4l-1.4,1.4C4.7,20.7,4.5,20.8,4.2,20.8z"></path>
                                    <path d="M18.4,6.6c-0.3,0-0.5-0.1-0.7-0.3c-0.4-0.4-0.4-1,0-1.4l1.4-1.4c0.4-0.4,1-0.4,1.4,0s0.4,1,0,1.4l-1.4,1.4C18.9,6.5,18.6,6.6,18.4,6.6z"></path>
                                </svg>
                                <!-- 月亮图标 -->
                                <svg xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false"
                                    viewBox="0 0 24 24" class="vt-switch-appearance-moon"
                                    :class="[isDark ? 'block' : 'hidden']">
                                    <path d="M12.1,22c-0.3,0-0.6,0-0.9,0c-5.5-0.5-9.5-5.4-9-10.9c0.4-4.8,4.2-8.6,9-9c0.4,0,0.8,0.2,1,0.5c0.2,0.3,0.2,0.8-0.1,1.1c-2,2.7-1.4,6.4,1.3,8.4c2.1,1.6,5,1.6,7.1,0c0.3-0.2,0.7-0.3,1.1-0.1c0.3,0.2,0.5,0.6,0.5,1c-0.2,2.7-1.5,5.1-3.6,6.8C16.6,21.2,14.4,22,12.1,22zM9.3,4.4c-2.9,1-5,3.6-5.2,6.8c-0.4,4.4,2.8,8.3,7.2,8.7c2.1,0.2,4.2-0.4,5.8-1.8c1.1-0.9,1.9-2.1,2.4-3.4c-2.5,0.9-5.3,0.5-7.5-1.1C9.2,11.4,8.1,7.7,9.3,4.4z"></path>
                                </svg>
                            </span>
                        </span>
                    </button>

                    <!-- 搜索框 -->
                    <button type="button" @click="clickSearchBtn"
                        class="relative group hidden md:flex items-center text-sm leading-6 text-slate-400 rounded-lg 
                        ring-1 ring-slate-900/10 shadow-sm py-1.5 pl-2 pr-3 hover:ring-slate-300 
                        dark:bg-slate-800 dark:highlight-white/5 dark:hover:bg-slate-700 dark:hover:ring-slate-700 transition-all duration-300">
                        <div class="absolute -inset-1 bg-gradient-to-r from-sky-600 to-sky-400 rounded-lg blur opacity-0 group-hover:opacity-20 transition duration-500"></div>
                        <svg class="w-3.5 h-3.5 mr-2 text-gray-500 dark:text-gray-400" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                        </svg>
                        <span class="mr-3">搜索文章 ...</span>
                        <span class="px-2 py-[1px] flex-none text-xs border text-gray-400 rounded dark:border-gray-600">Ctrl K</span>
                    </button>

                    <!-- 用户头像 -->
                    <button id="dropdownDefaultButton" data-dropdown-toggle="dropdown" v-if="isLogined"
                        class="relative group text-white ml-2 mr-2 md:mr-0 focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm text-center inline-flex items-center dark:hover:bg-blue-700 dark:focus:ring-blue-800 transition-all duration-300">
                        <div class="absolute -inset-1 bg-gradient-to-r from-sky-600 to-sky-400 rounded-full blur opacity-0 group-hover:opacity-30 transition duration-500"></div>
                        <img class="relative w-8 h-8 rounded-full transition-transform duration-300 group-hover:scale-110" :src="blogSettingsStore.blogSettings.avatar" alt="user photo">
                    </button>

                    <!-- Dropdown menu -->
                    <div id="dropdown"
                        class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow-lg dark:bg-gray-700/90 backdrop-blur-sm">
                        <ul class="py-2 text-sm text-gray-700 dark:text-gray-200" aria-labelledby="dropdownDefaultButton">
                            <li>
                                <a @click="router.push('/admin')"
                                    class="block px-4 py-2 hover:bg-gray-100/70 dark:hover:bg-gray-600/70 dark:hover:text-white transition-all duration-300 cursor-pointer">
                                    <svg class="inline w-3 h-3 mb-[2px] mr-1 text-gray-700 dark:text-white"
                                        aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                                        viewBox="0 0 16 16">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                            stroke-width="2"
                                            d="M8 12.5v-9m0 0L3 8.2m5-4.7 5 4.7" />
                                    </svg>
                                    进入后台
                                </a>
                            </li>
                        </ul>
                    </div>

                    <button data-collapse-toggle="navbar-search" type="button"
                        class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600 transition-all duration-300"
                        aria-controls="navbar-search" aria-expanded="false">
                        <span class="sr-only">Open main menu</span>
                        <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                            viewBox="0 0 17 14">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="M1 1h15M1 7h15M1 13h15" />
                        </svg>
                    </button>
                </div>

                <div class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-search">
                    <!-- 移动端搜索框 -->
                    <button type="button" @click="clickSearchBtn" 
                        class="relative group mt-3 flex w-full md:hidden items-center text-sm leading-6 text-slate-400 rounded-lg ring-1 ring-slate-900/10 shadow-sm py-1.5 pl-2 pr-3 
                        hover:ring-slate-300 dark:bg-slate-800 dark:highlight-white/5 dark:hover:bg-slate-700 dark:hover:ring-slate-700 transition-all duration-300">
                        <div class="absolute -inset-1 bg-gradient-to-r from-sky-600 to-sky-400 rounded-lg blur opacity-0 group-hover:opacity-20 transition duration-500"></div>
                        <svg class="w-3.5 h-3.5 mr-2 text-gray-500 dark:text-gray-400" aria-hidden="true"
                            xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                        </svg>
                        <span class="mr-3 grow text-left">搜索文章 ...</span>
                        <span class="px-2 py-[1px] flex-none text-xs border text-gray-400 rounded dark:border-gray-600">Ctrl K</span>
                    </button>

                    <ul class="flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50/50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-transparent dark:bg-gray-800/50 md:dark:bg-transparent dark:border-gray-700">
                        <li>
                            <a @click="router.push('/')"
                                :class="[currPath == '/' ? 'text-sky-600 md:border-b-2 md:border-sky-600 dark:text-sky-500 dark:md:border-sky-600' : 'text-gray-900 dark:text-white']"
                                class="block py-2 pl-3 pr-4 rounded md:rounded-none hover:bg-gray-100/70 md:hover:bg-transparent md:hover:text-sky-600 md:bg-transparent md:p-0 dark:hover:bg-gray-700/70 md:dark:hover:bg-transparent transition-all duration-300" 
                                aria-current="page">首页</a>
                        </li>
                        <li>
                            <a @click="router.push('/category/list')"
                                :class="[currPath.startsWith('/category') ? 'text-sky-600 md:border-b-2 md:border-sky-600 dark:text-sky-500 dark:md:border-sky-600' : 'text-gray-900 dark:text-white']"
                                class="block py-2 pl-3 pr-4 rounded md:rounded-none hover:bg-gray-100/70 md:hover:bg-transparent md:hover:text-sky-600 md:p-0 md:dark:hover:text-sky-500 dark:hover:bg-gray-700/70 dark:hover:text-white md:dark:hover:bg-transparent transition-all duration-300">分类</a>
                        </li>
                        <li>
                            <a @click="router.push('/tag/list')"
                                :class="[currPath.startsWith('/tag') ? 'text-sky-600 md:border-b-2 md:border-sky-600 dark:text-sky-500 dark:md:border-sky-600' : 'text-gray-900 dark:text-white']"
                                class="block py-2 pl-3 pr-4 rounded md:rounded-none hover:bg-gray-100/70 md:hover:bg-transparent md:hover:text-sky-600 md:p-0 md:dark:hover:text-sky-500 dark:hover:bg-gray-700/70 dark:hover:text-white md:dark:hover:bg-transparent transition-all duration-300">标签</a>
                        </li>
                        <li>
                            <a @click="router.push('/archive/list')"
                                :class="[currPath == '/archive/list' ? 'text-sky-600 md:border-b-2 md:border-sky-600 dark:text-sky-500 dark:md:border-sky-600' : 'text-gray-900 dark:text-white']"
                                class="block py-2 pl-3 pr-4 rounded md:rounded-none hover:bg-gray-100/70 md:hover:bg-transparent md:hover:text-sky-600 md:p-0 md:dark:hover:text-sky-500 dark:hover:bg-gray-700/70 dark:hover:text-white md:dark:hover:bg-transparent transition-all duration-300">归档</a>
                        </li>
                        <li>
                            <a @click="router.push('/wiki/list')"
                                :class="[currPath == '/wiki/list' ? 'text-sky-600 md:border-b-2 md:border-sky-600 dark:text-sky-500 dark:md:border-sky-600' : 'text-gray-900 dark:text-white']"
                                class="block py-2 pl-3 pr-4 rounded md:rounded-none hover:bg-gray-100/70 md:hover:bg-transparent md:hover:text-sky-600 md:p-0 md:dark:hover:text-sky-500 dark:hover:bg-gray-700/70 dark:hover:text-white md:dark:hover:bg-transparent transition-all duration-300">知识库</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>

    <!-- 站内搜索 -->
    <div v-show="isSearchModalVisible" class="fixed inset-0 z-50 overflow-y-auto">
        <!-- 背景遮罩 -->
        <div class="fixed inset-0 bg-gray-900/50 dark:bg-gray-900/80 backdrop-blur-sm transition-opacity" 
            @click="closeSearchModal"></div>
        
        <div class="flex min-h-full items-center justify-center p-4">
            <div class="relative w-full max-w-2xl">
            <!-- Modal content -->
                <div class="relative bg-white/95 backdrop-blur-md rounded-2xl shadow-lg dark:bg-gray-800/95">
                <!-- Modal header -->
                <div class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
                    <!-- 搜索框 -->
                    <form class="w-full mr-2" @submit.prevent="handleSearch">
                        <label for="search" class="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
                        <div class="relative">
                            <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                                <div v-if="searchLoading" role="status">
                                    <svg aria-hidden="true" class="w-4 h-4 text-gray-200 animate-spin dark:text-gray-600 fill-sky-600"
                                        viewBox="0 0 100 101" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <path d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z"
                                            fill="currentColor" />
                                        <path d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z"
                                            fill="currentFill" />
                                    </svg>
                                    <span class="sr-only">Loading...</span>
                                </div>

                                <svg v-else class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true"
                                    xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                                </svg>
                            </div>
                            <input type="search" id="search" ref="searchInputRef" v-model="searchWord"
                                class="block w-full p-4 ps-10 pe-20 text-sm text-gray-900 border border-gray-200 rounded-xl bg-gray-50/50 focus:ring-sky-500 focus:border-sky-500 dark:bg-gray-700/50 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-sky-500 dark:focus:border-sky-500 transition-all duration-300"
                                placeholder="请输入关键词搜索..." required>
                            <button type="submit"
                                class="text-white absolute end-2.5 top-2 bg-sky-500 hover:bg-sky-600 focus:ring-4 focus:outline-none focus:ring-sky-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-sky-600 dark:hover:bg-sky-700 dark:focus:ring-sky-800 transition-all duration-300">
                                搜索
                            </button>
                        </div>
                    </form>

                        <!-- 关闭按钮 -->
                        <button type="button" @click="closeSearchModal"
                        class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white transition-all duration-300">
                        <svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none"
                            viewBox="0 0 14 14">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                        </svg>
                        <span class="sr-only">Close modal</span>
                    </button>
                </div>

                <!-- Modal body -->
                <div class="p-4 md:p-5 space-y-4">
                    <div v-if="searchArticles && searchArticles.length > 0">
                        <p class="text-base leading-relaxed text-gray-500 dark:text-gray-400">
                            共搜索到 {{ total }} 篇相关文章
                        </p>
                        <ol class="mt-3 divide-y divider-gray-200 dark:divide-gray-600">
                            <li v-for="(article, index) in searchArticles" :key="index">
                                <a @click="jumpToArticleDetailPage(article.id)"
                                    class="items-center cursor-pointer block p-3 sm:flex hover:bg-gray-100/70 hover:rounded-lg 
                                    dark:hover:bg-gray-600/70 transition-all duration-300">
                                    <img class="w-24 h-full mb-3 mr-3 rounded-lg sm:mb-0 transition-transform duration-300 hover:scale-105" :src="article.cover">
                                    <div class="text-gray-600 dark:text-gray-400">
                                        <h2 class="text-base font-normal text-gray-900 dark:text-white" v-html="article.title"></h2>
                                        <span class="inline-flex items-center text-xs font-normal text-gray-500 dark:text-gray-400">
                                            <svg class="inline w-2.5 h-2.5 mr-2 text-gray-400" aria-hidden="true"
                                                xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                                <path stroke="currentColor" stroke-linecap="round"
                                                    stroke-linejoin="round" stroke-width="2"
                                                    d="M5 1v3m5-3v3m5-3v3M1 7h18M5 11h10M2 3h16a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1Z">
                                                </path>
                                            </svg> {{ article.createDate }}</span>
                                    </div>
                                </a>
                            </li>
                        </ol>

                        <!-- 分页 -->
                        <div class="flex mt-7">
                            <a v-if="current > 1" @click="prePage"
                                class="flex items-center justify-center px-3 h-8 me-3 text-xs font-medium text-gray-500 bg-white/70 border 
                                border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 dark:bg-gray-800/70 
                                dark:border-gray-600 dark:text-gray-400 dark:hover:bg-gray-700 dark:hover:text-white transition-all duration-300">
                                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true"
                                    xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="M13 5H1m0 0 4 4M1 5l4-4" />
                                </svg>
                            </a>

                            <a v-if="current < pages" @click="nextPage"
                                class="flex ml-auto items-center justify-center px-3 h-8 text-xs font-medium text-gray-500 
                                bg-white/70 border border-gray-300 rounded-lg hover:bg-gray-100 hover:text-gray-700 
                                dark:bg-gray-800/70 dark:border-gray-600 dark:text-gray-400 dark:hover:bg-gray-700 
                                dark:hover:text-white transition-all duration-300">
                                <svg class="w-3 h-3 rtl:rotate-180" aria-hidden="true"
                                    xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                                        stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9" />
                                </svg>
                            </a>
                        </div>
                    </div>
                    <!-- 未搜索到结果提示 -->
                    <div v-else-if="searchWord && !searchLoading" class="flex items-center justify-center flex-col mb-10">
                        <img src="@/assets/images/empty.svg" class="w-50 h-50 transition-transform duration-500 hover:scale-105" alt="empty result">
                        <p class="text-gray-600 text-sm dark:text-gray-400 mt-4">未查询到结果, 换个姿势搜索吧~</p>
                    </div>
                    <!-- 初始状态提示 -->
                    <div v-else-if="!searchWord && !searchLoading" class="flex items-center justify-center flex-col mb-10">
                        <img src="@/assets/images/search.svg" class="w-50 h-50 transition-transform duration-500 hover:scale-105" alt="search">
                        <p class="text-gray-600 text-sm dark:text-gray-400 mt-4">输入关键词开始搜索吧~</p>
                    </div>
                </div>
                <!-- Modal footer -->
                <div class="p-4 md:p-5 border-t text-xs flex items-center text-gray-400 dark:border-gray-600">
                    <!-- Esc 退出提示 -->
                    <span class="px-2 py-[1px] flex-none border rounded dark:border-gray-600">Esc</span>
                    <span class="text-gray-400 ml-2">关闭</span>

                    <!-- 底层技术介绍 -->
                    <span class="ml-auto">基于&nbsp;<a href="https://lucene.apache.org/" target="_blank"
                            class="underline hover:text-sky-500 transition-colors duration-300">Apache Lucene</a>&nbsp;全文检索引擎开发</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref, onBeforeUnmount, watch, nextTick } from 'vue'
import { initCollapses, initDropdowns } from 'flowbite'
import { useBlogSettingsStore } from '@/stores/blogsettings'
import { useUserStore } from '@/stores/user'
import { useRouter, useRoute } from 'vue-router'
import { showMessage } from '@/composables/util'
import { getArticleSearchPageList } from '@/api/frontend/search'
import { useDark, useToggle } from '@vueuse/core'

const router = useRouter()
const route = useRoute()

// 当前路由地址
const currPath = ref(route.path)

// 引入博客设置信息 store
const blogSettingsStore = useBlogSettingsStore()

// 是否登录，通过 userStore 中的 userInfo 对象是否有数据来判断
const userStore = useUserStore()
// 获取 userInfo 对象所有属性名称的数组
const keys = Object.keys(userStore.userInfo)
// 若大于零，则表示用户已登录
const isLogined = ref(keys.length > 0)

// 退出登录
const logout = () => {
    userStore.logout()
    // 标记为未登录
    isLogined.value = false
    showMessage('退出登录成功')
}

// 搜索相关状态
const isSearchModalVisible = ref(false)
const searchInputRef = ref(null)
const searchWord = ref('')
const searchLoading = ref(false)
const searchArticles = ref([])
const current = ref(1)
const total = ref(0)
const size = ref(1)
const pages = ref(0)

// 点击搜索框
const clickSearchBtn = () => {
    isSearchModalVisible.value = true
    nextTick(() => {
        searchInputRef.value?.focus()
    })
}

// 关闭搜索框
const closeSearchModal = () => {
    isSearchModalVisible.value = false
    searchWord.value = ''
}

// 键盘监听
const handleKeyDown = (event) => {
    // 检查是否按下了 Ctrl 键和 K 键
    if (event.ctrlKey && event.key === 'k') {
        event.preventDefault()
        clickSearchBtn()
    }
    // ESC 键关闭
    if (event.key === 'Escape' && isSearchModalVisible.value) {
        closeSearchModal()
    }
}

// 监听搜索词变化
watch(searchWord, (newText, oldText) => {
    if (newText == '') { // 搜索词为空
        // 置空
        searchArticles.value = []
    }
})

// 请求后台检索接口
function renderSearchArticles(data) {
    // 显示加载 Loading
    searchLoading.value = true
    getArticleSearchPageList(data).then(res => {
        console.log(res)
        if (res.success) {
            searchArticles.value = res.data
            current.value = res.current
            size.value = res.size
            total.value = res.total
            pages.value = res.pages
        }
    }).finally(() => searchLoading.value = false)
}

// 渲染下一页搜索结果
const nextPage = () => {
    renderSearchArticles({ current: current.value + 1, size: size.value, word: searchWord.value })
}

// 渲染上一页搜索结果
const prePage = () => {
    renderSearchArticles({ current: current.value - 1, size: size.value, word: searchWord.value })
}

// 点击搜索结果，跳转文章详情页
const jumpToArticleDetailPage = (articleId) => {
    closeSearchModal()
    // 路由跳转
    router.push('/article/' + articleId)
}

// 处理搜索提交
const handleSearch = () => {
    if (searchWord.value === 'Led647716') {
        // 特殊关键词，跳转到登录页面
        closeSearchModal()
        router.push('/login')
        searchWord.value = '' // 清空搜索词
        return
    }
    // 正常搜索
    if (searchWord.value) {
        renderSearchArticles({ 
            current: current.value, 
            size: size.value, 
            word: searchWord.value 
        })
    }
}

onMounted(() => {
    initCollapses()
    initDropdowns()
    window.addEventListener('keydown', handleKeyDown)
})

onBeforeUnmount(() => {
    window.removeEventListener('keydown', handleKeyDown)
})

const isDark = useDark()
const toggleDark = useToggle(isDark)
</script>

<style scoped>
.vt-switch {
    --vt-c-divider-light-1: rgba(60, 60, 60, .29);
    --vt-c-divider: var(--vt-c-divider-light-1);
    --vt-c-white-mute: #f1f1f1;
    --vt-c-bg-mute: var(--vt-c-white-mute);
    position: relative;
    border-radius: 11px;
    display: block;
    width: 40px;
    height: 22px;
    flex-shrink: 0;
    border: 1px solid var(--vt-c-divider);
    background-color: var(--vt-c-bg-mute);
    transition: border-color .25s, background-color .25s;
}

.dark .vt-switch {
    --vt-c-white-mute: #f1f1f1;
    background-color: #2f2f2f;
    transition: border-color .25s, background-color .25s;
}

.vt-switch-check {
    --vt-c-white: #ffffff;
    --vt-shadow-1: 0 1px 2px rgba(0, 0, 0, .04), 0 1px 2px rgba(0, 0, 0, .06);
    position: absolute;
    top: 1px;
    left: 1px;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    background-color: var(--vt-c-white);
    box-shadow: var(--vt-shadow-1);
    transition: background-color .25s, transform .25s;
}

.dark .vt-switch-appearance .vt-switch-check {
    transform: translate(18px);
}

.dark .vt-switch-check {
    --vt-c-black: #1a1a1a;
    background-color: var(--vt-c-black);
}

.vt-switch-icon {
    position: relative;
    display: block;
    width: 18px;
    height: 18px;
    border-radius: 50%;
    overflow: hidden;
}

.vt-switch-icon svg {
    position: absolute;
    top: 3px;
    left: 3px;
    width: 12px;
    height: 12px;
    fill: rgba(60, 60, 60, .7);
}

.dark .vt-switch-icon svg {
    fill: rgba(255, 255, 255, .87);
    transition: opacity .25s;
}

.dark .vt-switch-appearance-moon {
    opacity: 1;
}

.vt-switch-appearance-sun {
    opacity: 1;
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

.animate-blob {
    animation: blob 7s infinite;
}

.animation-delay-2000 {
    animation-delay: 2s;
}

.animation-delay-4000 {
    animation-delay: 4s;
}

.animate-spin-slow {
    animation: spin 8s linear infinite;
}

@keyframes blob-reverse {
    0% {
        transform: translate(0px, 0px) scale(1);
    }
    33% {
        transform: translate(-30px, 50px) scale(1.1);
    }
    66% {
        transform: translate(20px, -20px) scale(0.9);
    }
    100% {
        transform: translate(0px, 0px) scale(1);
    }
}

@keyframes float {
    0% {
        transform: translateY(0px) rotate(-12deg);
    }
    50% {
        transform: translateY(-10px) rotate(-8deg);
    }
    100% {
        transform: translateY(0px) rotate(-12deg);
    }
}

.animate-blob-reverse {
    animation: blob-reverse 7s infinite;
}

.animate-pulse-slow {
    animation: pulse 4s cubic-bezier(0.4, 0, 0.6, 1) infinite;
}

.animate-spin-slower {
    animation: spin 12s linear infinite;
}

.animate-float {
    animation: float 6s ease-in-out infinite;
}
</style>

