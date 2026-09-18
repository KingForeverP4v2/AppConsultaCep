# AppConsultaCEP

Aplicativo Android simples, desenvolvido em **Kotlin**, para consulta de endereços a partir do CEP (Código de Endereçamento Postal) utilizando a API pública [ViaCEP](https://viacep.com.br/).

## 📱 Funcionalidades

- Consulta de endereço a partir de um CEP de 8 dígitos
- Validação básica do CEP informado
- Preenchimento automático dos campos:
  - Logradouro
  - Bairro
  - UF
  - Cidade
  - DDD

## 🛠️ Tecnologias utilizadas

- **Kotlin**
- **Android SDK** (mínimo 24, alvo/compilação 36)
- **Retrofit 2** — cliente HTTP para consumo da API REST
- **Gson Converter** — conversão automática de JSON para objetos Kotlin
- **Coroutines** (`lifecycleScope`) — chamadas assíncronas à API
- **AndroidX / Material Components**

## 🌐 API utilizada

O app consome a API pública e gratuita do [ViaCEP](https://viacep.com.br/):

```
GET https://viacep.com.br/ws/{cep}/json/
```

## 📂 Estrutura do projeto

```
app/src/main/java/com/example/appconsultacep/
├── Api/
│   ├── ViaCepClient.kt      # Configuração do Retrofit
│   └── ViaCepService.kt     # Interface do serviço (endpoint)
├── Model/
│   └── ResponceEndereco.kt  # Modelo de dados do endereço
└── MainActivity.kt          # Tela principal e lógica de consulta
```

## ▶️ Como executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/murilo345-cmd/APPConsultaCEP.git
   ```
2. Abra o projeto no **Android Studio**.
3. Aguarde a sincronização do Gradle.
4. Execute em um emulador ou dispositivo físico (Android 7.0 / API 24 ou superior).

## 📋 Requisitos

- Android Studio (versão recente)
- JDK 11+
- Conexão com a internet (necessária para consultar a API)

## 📄 Licença

Este projeto está disponível livremente para fins de estudo e aprendizado.
