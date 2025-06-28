# meta-meuprojeto

Camada (layer) customizada para o Yocto Project, contendo receitas e configurações específicas para o projeto "meuprojeto".

## Visão Geral

Este layer adiciona funcionalidades e pacotes extras ao build do Yocto, permitindo personalizar a imagem Linux para o seu hardware ou aplicação específica. Ele foi desenvolvido como parte do projeto `yocto_first_proj`.

## Pré-requisitos

* Host com Linux (Ubuntu/Debian, Fedora, etc.)
* Dependências básicas do Yocto Project:

  ```bash
  sudo apt-get install -y gawk wget git-core diffstat unzip texinfo gcc-multilib build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping
  ```
* Repositório **poky** (ou outro "distro" base) clonado e configurado.

## Estrutura do Layer

```bash
meta-meuprojeto/
├── conf/
│   ├── layer.conf           # Configurações do layer (nome, compatibilidade, paths)
│   └── machine/
│       └── <MAQUINA>.conf   # Arquivo opcional de definição de máquina (ex: beaglebone.conf)
├── recipes-
│   ├── examples/
│   │   └── meu-hello/
│   │       ├── meu-hello.bb # Exemplo de receita Hello World
│   ├── core/
│   │   └── ...
│   └── ...
└── README.md                # Este documento
```

> **Importante**: ajuste `<MAQUINA>.conf` para sua placa ou arquitetura alvo, se aplicável.

## Como Usar

1. Clone o repositório principal e o layer:

   ```bash
   git clone https://github.com/DiegoJustino-lab1/yocto_first_proj.git
   cd yocto_first_proj
   ```
2. Clone ou atualize o submódulo Poky (ou outro distro):

   ```bash
   git submodule update --init poky
   ```
3. Configure o ambiente Yocto:

   ```bash
   source poky/oe-init-build-env build
   ```
4. Adicione o layer `meta-meuprojeto` no seu `bblayers.conf` (na pasta `build/conf`):

   ```diff
   BBLAYERS ?= " \
     ...
   + ${TOPDIR}/../meta-meuprojeto \
   "
   ```
5. (Opcional) Defina a máquina alvo em `local.conf`:

   ```conf
   MACHINE ??= "<MAQUINA>"
   ```
6. Construa a imagem ou receita desejada:

   ```bash
   bitbake core-image-minimal
   # ou receita específica
   bitbake meu-hello
   ```

## Receitas Disponíveis

* **meu-hello**: exemplo simples em C que imprime "Olá, Yocto!".
* *(adicione aqui outras receitas que seu layer fornece)*

## Como Adicionar Novas Receitas

1. Crie uma pasta em `recipes-<categoria>/<nome-da-receita>/`.
2. Adicione o arquivo `<nome-da-receita>.bb` com a descrição da receita.
3. Ajuste o `SRC_URI`, `DEPENDS`, `LIC_FILES_CHKSUM` e demais variáveis necessárias.
4. Execute `bitbake <nome-da-receita>` para testar.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE)
