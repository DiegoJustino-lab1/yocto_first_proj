SUMMARY = "Exemplo simples de app C++"
LICENSE = "MIT"
SRC_URI = "file://hello.cpp"

S = "${WORKDIR}"

do_compile() {
    ${CXX} hello.cpp -o hello
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 hello ${D}${bindir}
}