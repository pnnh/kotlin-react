
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import react.dom.input

external interface HeaderProps : RProps {
    var title: String
}

data class HeaderState(val title: String) : RState

@JsExport()
class Header(props: HeaderProps) : RComponent<HeaderProps, HeaderState>(props) {

    init {
        state = HeaderState(props.title)
    }

    override fun RBuilder.render() {
        h1 {
            +"这是标题一，${state.title}"
        }
        input {
            attrs {
                type = InputType.text
                value = state.title
                onChangeFunction = { event: Event ->
                    setState(
                        HeaderState(title = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
    }
}

external interface WelcomeProps : RProps {
    var name: String
}

data class WelcomeState(val name: String) : RState

@JsExport
class Welcome(props: WelcomeProps) : RComponent<WelcomeProps, WelcomeState>(props) {

    init {
        state = WelcomeState(props.name)
    }

    override fun RBuilder.render() {
        div {
            +"Hello, ${state.name}"
        }
        input {
            attrs {
                type = InputType.text
                value = state.name
                onChangeFunction = { event ->
                    setState(
                            WelcomeState(name = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }
        child(Header::class){
            attrs {
               title = "dddd2ee"
            }
        }
    }
}
