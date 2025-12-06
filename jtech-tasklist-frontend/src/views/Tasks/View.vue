<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import axios from 'axios'
import type { Task } from '@/types/Task'

const tasks = ref<Task[]>([])
const router = useRouter()
const route = useRoute()

const deleteSuccess = ref<string | null>(null)
const deleteError = ref<string | null>(null)
const showModal = ref(false)
const taskToDelete = ref<Task | null>(null)

const successMessage = computed(() => {
  if (route.query.success === 'created') return 'Tarefa criada com sucesso.'
  if (route.query.success === 'updated') return 'Tarefa atualizada com sucesso.'
  return null
})

onMounted(async () => {
  await fetchTasks()
})

async function fetchTasks() {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/tasklists')
    tasks.value = response.data
  } catch (error) {
    console.error('Error fetching tasks:', error)
  }
}

function confirmDelete(task: Task) {
  taskToDelete.value = task
  showModal.value = true
}

async function deleteTaskConfirmed() {
  if (!taskToDelete.value?.id) return

  deleteSuccess.value = null
  deleteError.value = null
  showModal.value = false

  try {
    await axios.delete(`http://localhost:8080/api/v1/tasklists/${taskToDelete.value.id}`)
    tasks.value = tasks.value.filter(task => task.id !== taskToDelete.value?.id)
    deleteSuccess.value = 'Tarefa excluída com sucesso.'
  } catch (error: any) {
    console.error('Error deleting task:', error)
    deleteError.value = error.response?.data?.message || 'Failed to delete task.'
  }
}

function formatStatus(status: string): string {
  if (!status) return ''
  return status
    .toLowerCase()
    .split('_')
    .map(word => word.charAt(0).toUpperCase() + word.slice(1))
    .join(' ')
}
</script>

<template>
  <main class="container">
    <h2 class="my-4 text-center">Lista de tarefas</h2>

    <div v-if="successMessage" class="alert alert-success alert-dismissible fade show" role="alert">
      {{ successMessage }}
      <button type="button" class="btn-close" @click="router.replace({ query: {} })"></button>
    </div>

    <div v-if="deleteSuccess" class="alert alert-success alert-dismissible fade show" role="alert">
      {{ deleteSuccess }}
      <button type="button" class="btn-close" @click="deleteSuccess = null"></button>
    </div>

    <div v-if="deleteError" class="alert alert-danger alert-dismissible fade show" role="alert">
      {{ deleteError }}
      <button type="button" class="btn-close" @click="deleteError = null"></button>
    </div>

    <div class="table-responsive">
      <table class="table table-bordered align-middle text-center">
        <thead class="table-light">
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Título</th>
            <th scope="col">Descrição</th>
            <th scope="col" class="">Status atual</th>
            <th scope="col" class="text-center text-bg-primary text-wrap" style="width: 100px;">Ações</th>
          </tr>
        </thead>
        <tbody v-if="tasks.length > 0">
          <tr v-for="(task, index) in tasks" :key="task.id">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ task.title }}</td>
            <td>{{ task.description }}</td>
            <td>{{ formatStatus(task.status) }}</td>
            <td class="text-center align-middle" style="width: 100px;">
              <RouterLink
                :to="`/form/${task.id}`"
                class="btn btn-primary btn-sm rounded-circle me-2"
                title="Editar tarefa"
              >
                <i class="bi bi-pencil"></i>
              </RouterLink>

              <button
                type="button"
                class="btn btn-danger btn-sm rounded-circle"
                @click="confirmDelete(task)"
                title="Deletar tarefa"
              >
                <i class="bi bi-x-square"></i>
              </button>
            </td>
          </tr>
        </tbody>
        <tbody v-else>
          <tr>
            <td colspan="5" class="text-center">Nenhuma tarefa encontrada</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="mt-4">
      <button
        type="button"
        class="btn btn-primary"
        @click="router.push('/form')"
        title="Criar nova tarefa"
      >
        <i class="bi bi-clipboard2-plus"></i>
        Adicionar
      </button>
    </div>

    <div
      class="modal fade"
      tabindex="-1"
      :class="{ show: showModal }"
      style="display: block; background-color: rgba(0, 0, 0, 0.5);"
      v-if="showModal"
    >
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Confirmar exclusão</h5>
            <button type="button" class="btn-close" @click="showModal = false"></button>
          </div>
          <div class="modal-body">
            <p>Tem certeza que deseja excluir a tarefa? <strong>{{ taskToDelete?.title }}</strong>?</p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" @click="showModal = false">Cancelar</button>
            <button type="button" class="btn btn-danger" @click="deleteTaskConfirmed">Excluir</button>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<style scoped>
.container {
  max-width: 900px;
  margin: 0 auto;
}

.table {
  margin: 20px 0 5px 0;
}


.text-nowrap {
  white-space: nowrap;
}

.modal {
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1050;
  width: 100%;
  height: 100%;
  overflow: hidden;
  outline: 0;
}
</style>
