package diogo.com.br.desafioguiabolson.util

data class Response<out T> (
    val state: State,
    val data: T?,
    val error: Throwable?
)