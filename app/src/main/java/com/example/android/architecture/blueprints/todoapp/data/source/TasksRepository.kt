package com.example.android.architecture.blueprints.todoapp.data.source

import androidx.lifecycle.LiveData
import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Task

interface TasksRepository : TasksDataSource {
    override suspend fun getTasks(forceUpdate: Boolean): Result<List<Task>>

    override suspend fun refreshTasks()

    override fun observeTasks(): LiveData<Result<List<Task>>>

    override suspend fun refreshTask(taskId: String)

    override fun observeTask(taskId: String): LiveData<Result<Task>>

    /**
     * Relies on [getTasks] to fetch data and picks the task with the same ID.
     */
    override suspend fun getTask(taskId: String, forceUpdate: Boolean): Result<Task>

    override suspend fun saveTask(task: Task)

    override suspend fun completeTask(task: Task)

    override suspend fun completeTask(taskId: String)

    override suspend fun activateTask(task: Task)

    override suspend fun activateTask(taskId: String)

    override suspend fun clearCompletedTasks()

    override suspend fun deleteAllTasks()

    override suspend fun deleteTask(taskId: String)
}