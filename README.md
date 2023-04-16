# Microsserviço que busca os certificados na DIO | [Digital Innovation One](https://web.dio.me/) | 2023
 

# Sobre o Projeto apresentado

Esse [microsserviço](https://github.com/P3d50/certificates) faz webscrapping na pagina da DIO, utilizando o login e senha para obter os certificados da conta.
Foi utilizado Java, Spring Boot, Api do chrome web driver.


# Sobre a execução do projeto
  - clonar o projeto
  - na pasta raiz do projeto executar o comando abaixo, para dar permissão de execução para o script, esse script builda a imagem do container e roda uma instância do container.

    ```bash
      $ chmod +x start.sh
    ```
  - executar o script 
    ```bash
      $ ./start.sh
    ```
    
  - acessar a url do local onde o container está rodando com a porta "8081" e a uri "/home", ex: http://localhost:8081/home
 

# Sobre a integração com outros microsserviços

 - [busca os certificados na plataforma da DIO](https://github.com/P3d50/certificates)
 - [envia as informações para o chat-GPT3 via api](https://github.com/P3d50/chatgtp)
 - [API que consome os dois serviços acima](https://github.com/P3d50/dio-bio)
 
 - considerar que tem que inserir informações de usuário e senha da plataforma do .properties do projeto
 - considerar que esses projetos estão em fase inicial e não foram pensadas questões como privacidade e segurança, existem algumas coisas hardcoded que serão melhoradas posteriormente, utilize com cautela.
 - as urls dos serviços estão em hardcoded, chaves de api, etc.. considere isso antes de subir esses projetos para alguma núvem pública.
 
 


# Autor

P3d50

https://www.linkedin.com/in/pedro-ramos-3b35aaa0/
