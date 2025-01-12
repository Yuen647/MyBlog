<template>
    <footer class="relative bg-gradient-to-r from-gray-50 to-gray-100 mt-3 dark:from-gray-800 dark:to-gray-900 overflow-hidden">
        <!-- 装饰性背景元素 -->
        <div class="absolute inset-0 grid grid-cols-2 -space-x-52 opacity-40 dark:opacity-20">
            <div class="blur-[106px] h-32 bg-gradient-to-br from-sky-400 to-sky-200"></div>
            <div class="blur-[106px] h-20 bg-gradient-to-r from-cyan-400 to-sky-300"></div>
        </div>

        <div class="max-w-screen-xl w-full mx-auto py-4 px-4 relative">
            <div class="md:flex md:items-center md:justify-between">
                <div class="flex items-center justify-center md:justify-start space-x-3">
                    <div class="text-xs text-gray-600 dark:text-gray-300 hover:text-sky-500 dark:hover:text-sky-400 transition duration-300">
                        © 2023 <a href="https://www.quanxiaoha.com/" class="hover:underline font-medium">李沅衡</a>
                    </div>
                    <div class="h-3 w-px bg-gray-300 dark:bg-gray-600"></div>
                    <div class="text-xs text-gray-600 dark:text-gray-300">
                        All Rights Reserved.
                    </div>
                </div>
                
                <ul class="flex flex-wrap items-center justify-center md:justify-end mt-2 md:mt-0 space-x-4">
                    <li>
                        <a href="#" class="text-xs text-gray-600 dark:text-gray-300 hover:text-sky-500 dark:hover:text-sky-400 transition duration-300">
                            <span class="relative inline-flex items-center">
                                <span class="animate-ping absolute inline-flex h-1.5 w-1.5 rounded-full bg-sky-400 opacity-75"></span>
                                <span class="relative inline-flex rounded-full h-1.5 w-1.5 bg-sky-500"></span>
                                <span class="ml-2">备案号</span>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </footer>
</template>
