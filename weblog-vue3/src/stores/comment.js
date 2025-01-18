import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useCommentStore = defineStore('comment', () => {
  // 评论用户信息
  const userInfo = ref({
    nickname: '',
    avatar: '',
    mail: '',
    website: ''
  })

  return { userInfo }
},
{
  // 开启持久化
  persist: true,
}
)