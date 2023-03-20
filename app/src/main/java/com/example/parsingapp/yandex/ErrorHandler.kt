package com.example.parsingapp.yandex

/*
Что нужно сделать:
реализуйте свой собственный sealed class NetworkError, который будет иметь 3 состояния: ServerError, NoData и NoInternet.

ServerError говорит, что запрос получил ошибку с сервера.
NoData ошибка говорит, что в ответе на сетевой запрос пришли пустые данные.
NoInternet говорит об отсутствии интернета на устройстве пользователя.
в классе ErrorHandler есть метод handleError(), который будет получать и обрабатывать ошибки. Ваша задача описать в
нём логику обработки каждого вида ошибки.
в классе Network метод onNetworkError() будет вызван всякий раз, когда будет получена ошибка. Ваша задача в зависимости
от кода ошибки сгенерировать правильный экземпляр класса NetworkError.

При создании подклассов для sealed class действуют те же правила, что и для обычного наследования. Мы должны
переопределить все абстрактные методы и вызвать конструктор суперкласса.
Конструкция when может вам помочь для обработки кодов ошибок.
*/

class ErrorHandler {

    fun handleError(error: NetworkError) {
        // в этот метод будут приходить ошибки, полученные при выполнении запросов
        // обработайте ошибки:
        // если это ошибка сервера (ServerError) - просто покажите сообщение с ошибкой
        // если данные не получены (NoData) - покажите пустой экран
        // при отсутствии интернета (NoInternet) - показать ошибку пользователю и заново выполнить запрос (метод reloadRequest())

        when (error) {
            is NetworkError.ServerError -> showErrorMessage(error.message)
            is NetworkError.NoData -> showEmptyContent()
            is NetworkError.NoInternet -> reloadRequest(error.requestId)
        }
    }

    private fun showErrorMessage(message: String) {
        println(message)
    }

    private fun showEmptyContent() {
        println("Показываем пустой экран")
    }

    private fun reloadRequest(requestId: String) {
        println("При появлении подключения к интернету перезапускаем запрос: id = $requestId")
    }
}

class Network {

    fun onNetworkError(code: Int?, requestId: String, error: String?): NetworkError =
    // метод будет вызываться программой всякий раз, когда будет получена ошибка
    // возвращать ошибку NoInternet, если code = null
    // возвращать ошибку NoData, если code = 200
        // возвращать ошибку ServerError во всех остальных случаях
        when (code) {
            null -> NetworkError.NoInternet(requestId = requestId)
            200 -> NetworkError.NoData(requestId = requestId)
            else -> NetworkError.ServerError(requestId = requestId, message = error)
        }
}

// реализуйте sealed класс NetworkError, который будет принимать на вход поле message типа String
// у класса NetworkError должно быть 3 наследника

// ServerError -> принимает на вход 2 параметра: requestId: String и message: String?.
// Должен передавать в родительский класс NetworkError сообщение:
// "Ошибка взаимодействия с сервером для запроса: id = $requestId. Сообщение об ошибке: $message"

// NoData -> на вход принимает только requestId: String. Передаёт сообщение в конструктор родителя: "Для запроса: id = $requestId нет данных"

// NoInternet -> на вход принимает только requestId: String. Поле должно быть доступно за пределами класса, т. е. должно быть объявлено как val
// Передаёт сообщение в конструктор родителя: "Нет подключения к интернету."

sealed class NetworkError(var message: String) {

    class ServerError(requestId: String, message: String?) :
        NetworkError("Ошибка взаимодействия с сервером для запроса: id = $requestId. Сообщение об ошибке: $message")

    class NoData(requestId: String) :
        NetworkError("Для запроса: id = $requestId нет данных")

    class NoInternet(val requestId: String) :
        NetworkError("Нет подключения к интернету.")

}

/*

В любом приложении могут быть ошибки. Один из ключевых показателей хорошего приложения — правильная обработка ошибок.
В нашем приложении также могут быть ошибки сети. Каждый раз, когда нам нужно получить какую-то информацию из удалённого
сервера, мы совершаем сетевой запрос.
Запросы могут вернуть ошибку, но ошибки бывают разные. В нашем случае их 3 вида:

Ошибка сервера. Такая ошибка возникает, когда на удалённом сервере какой-то сбой. Мы не можем ничего с этим сделать,
потому всё, что мы можем — это показать пользователю сообщение об ошибке.

Нет данных. Такая ошибка говорит, что запрос отработал успешно, но по какой-то причине не вернул данных. В такой
ситуации нам лучше показать пользователю экран с пустыми данными (заглушку).

Нет соединения с интернетом. Показываем пользователю сообщение об отсутствии соединения и при возобновлении заново выполняем запрос.

*/
fun <T> Collection<T>.printMe() {
    println(this)
}

fun <T> Collection<T>.funMe(myFun: (i: Int) -> Unit) {



}

enum class Monda{

}