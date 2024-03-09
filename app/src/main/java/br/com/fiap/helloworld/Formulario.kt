package br.com.fiap.helloworld


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.helloworld.ui.theme.HelloWorldTheme

class Formulario: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
//                    Greeting()

                    BasicComponentsScreen()
                }
            }
        }
    }
}

//@Composable
//fun Greeting() {
//    Column(modifier = Modifier
//        .padding(32.dp)
//        .fillMaxWidth()) {
//        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
//            value = "FIAP",
//            onValueChange = {},
//            placeholder = { Text("O que você está procurando?") },
//            trailingIcon = {
//                Icon(
//                    painter = painterResource(
//                        id = R.drawable.baseline_search_24
//                    ),
//                    contentDescription = "Botão procurar"
//                )
//            })
//    }
//}

@Preview
@Composable
fun BasicComponentsScreen() {

    //para que variável mude de estado e se lembre
    var nomeUsuario = remember {
        mutableStateOf("")
    }

    var feminino by remember {
        mutableStateOf(false)
    }

    var masculino by remember {
        mutableStateOf(false)
    }
    var naoInformado by remember {
        mutableStateOf(false)
    }

    var botaoCadastrar by remember {
        mutableStateOf(Color.Gray)
    }


    Column(
        //modificadores do container coluna
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(32.dp)

    ) {
        Text(
            text = "FIAP",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(237, 20, 91),
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Text(
            text = "Desenvolvendo aplicações Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        //espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

        // entrada de valor pelo usuário:
        TextField(
            value = nomeUsuario.value,
            onValueChange = { novoValor ->
                nomeUsuario.value = novoValor
            },

            modifier = Modifier.fillMaxWidth(),   //o texto ocupa a extensão toda na horizontal
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences // permite que o teclado deixa a primeira letra maiúscula
            ),

            // texto de dentro, sai quando o usuário digita
            label = {
                Text(text = "Qual o seu nome?")
            },

            //dica que fica em cima
            placeholder ={
                Text(text= "Nome do usuário")
            },

            //ícone do início do TextField
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "ícone de um usuário ",
                    tint = Color(237, 20, 91)
                )
            },

            //ícone do final do textField
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable._info),
                    contentDescription = "ícone de informação",
                    tint = Color(237, 20, 91)
                )

            },
            textStyle = TextStyle(fontSize = 20.sp ),
            colors = TextFieldDefaults.colors(focusedTextColor = Color(237,20,91), unfocusedTextColor = Color.Gray)



        )

        //espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

        var quantidade = remember {
            mutableStateOf("")
        }

//para que variável mude de estado e se lembre
        var emailUsuario = remember {
            mutableStateOf("")
        }

        TextField(
            value = emailUsuario.value,
            onValueChange = { novoValor ->
                emailUsuario.value = novoValor
            },
            //o texto ocupa a extensão toda na horizontal
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email // permite que o teclado deixa a primeira letra maiúscula
            ),
            // texto de dentro, sai quando o usuário digita
            label = {
                Text(text = "Qual o seu e-mail?")
            },
            placeholder ={
                Text(text= "E-mail?")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_email_24),
                    contentDescription = "ícone de informação",
                    tint = Color(237, 20, 91)
                )
            },
            textStyle = TextStyle(fontSize = 20.sp ),
            colors = TextFieldDefaults.colors(focusedTextColor = Color(237,20,91), unfocusedTextColor = Color.Gray)


        )
//espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

//para que variável mude de estado e se lembre
        var senhaConfirmadaUsuario = remember {
            mutableStateOf("")
        }
        TextField(
            value = senhaConfirmadaUsuario.value,
            onValueChange = { novoValor ->
                senhaConfirmadaUsuario.value = novoValor
            },
            //o texto ocupa a extensão toda na horizontal
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword // permite que o teclado deixa a primeira letra maiúscula
            ),
            // texto de dentro, sai quando o usuário digita
            label = {
                Text(text = "Senha")
            },
            placeholder ={
                Text(text= "Qual será a sua senha?")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_password_24),
                    contentDescription = "ícone de informação",
                    tint = Color(237, 20, 91)
                )
            },
            textStyle = TextStyle(fontSize = 20.sp ),
            colors = TextFieldDefaults.colors(focusedTextColor = Color(237,20,91), unfocusedTextColor = Color.Gray)


        )
//espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

//para que variável mude de estado e se lembre
        var senhaUsuario = remember {
            mutableStateOf("")
        }
        TextField(
            value = senhaUsuario.value,
            onValueChange = { novoValor ->
                senhaUsuario.value = novoValor
            },
            //o texto ocupa a extensão toda na horizontal
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword // permite que o teclado deixa a primeira letra maiúscula
            ),
            // texto de dentro, sai quando o usuário digita
            label = {
                Text(text = "Confirme a Senha")
            },

            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_password_24),
                    contentDescription = "ícone de informação",
                    tint = Color(237, 20, 91)
                )
            },
            textStyle = TextStyle(fontSize = 20.sp ),
            colors = TextFieldDefaults.colors(focusedTextColor = Color(237,20,91), unfocusedTextColor = Color.Gray)

        )

        //espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

        Row (verticalAlignment = Alignment.CenterVertically){
            Checkbox(checked = feminino, onCheckedChange ={isSelected ->
                feminino = isSelected
            } ,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed145b)
                )
            )
            Text(text = "Feminino", color = Color.White)

            Checkbox(checked = masculino, onCheckedChange ={isSelected ->
                masculino = isSelected

            } ,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed145b)
                )
            )
            Text(text = "Masculino", color = Color.White)

            Checkbox(checked = naoInformado, onCheckedChange ={isSelected ->
                naoInformado = isSelected

            } ,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.White,
                    uncheckedColor = Color(0xffed145b)
                )
            )
            Text(text = "Prefiro não informar", color = Color.White)
        }

        //espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

        var generoSelecionado by remember{
            mutableStateOf(-1)
        }

        Row(verticalAlignment =  Alignment.CenterVertically){
            RadioButton(
                selected = generoSelecionado == 0,
                onClick = { generoSelecionado = 0 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xffed145b),
                    unselectedColor = Color(0xffed145b))
            )
            Text(text = "Não informar", color = Color.White, fontSize = 11.sp)

            RadioButton(
                selected = generoSelecionado == 1,
                onClick = { generoSelecionado = 1},
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xffed145b),
                    unselectedColor = Color(0xffed145b)))
            Text(text = "Feminino", color = Color.White, fontSize = 11.sp)

            RadioButton(
                selected = generoSelecionado ==2,
                onClick = { generoSelecionado = 2},
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xffed145b),
                    unselectedColor = Color(0xffed145b)))
            Text(text = "Masculino", color = Color.White, fontSize = 11.sp)
        }

        //espaço entre os textField
        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()){
            Button(
                onClick =  { botaoCadastrar = Color(237, 20, 91)},
                modifier = Modifier
                    .size(width = 250.dp, height = 48.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = botaoCadastrar)


            ){

                Text(text = "Cadastrar")
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24), contentDescription = "Seta")


            }

        }
    }




    @Composable
    fun CounterScreen(//horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
        //verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center
    ) {
        var idade = remember{
            mutableStateOf(0)
        }
        Column() {
            Text(
                text = "Qual a sua idade?",
                color = Color.Red,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                //modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Aperte os botões para informar a sua idade.",
                fontSize = 12.sp,
                color = Color.Blue,
                textAlign = TextAlign.Center,
                // modifier = Modifier.fillMaxWidth()

            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "${idade.value}",
                fontSize = 48.sp,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    idade.value --
                    Log.i("FIAP","MeuComponente: $idade")
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)){
                    Text(text = "-")
                }
                Spacer(modifier = Modifier.width(50.dp))

                Button(onClick = {
                    idade.value ++
                    Log.i("FIAP","MeuComponente: $idade")
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)){
                    Text(text = "+")
                }
            }
        }
    }}
