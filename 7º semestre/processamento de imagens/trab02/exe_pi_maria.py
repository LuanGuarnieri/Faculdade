import cv2
from tkinter import Tk, filedialog
from matplotlib import pyplot as plt

def main():
    exe_01()
    exe_02()
    exe_03()
    exe_04()
    exe_05()

def selecionar_img():
    root = Tk()
    root.withdraw()
    path_img = filedialog.askopenfilename(defaultextension='.png')
    root.destroy()

    return path_img

def mostrar_img(img, img_titulo):
    if img is not None:
        cv2.imshow(img_titulo, img)
        cv2.waitKey(0)
        cv2.destroyAllWindows()

def salvar_img(img, img_nome):
    if img is not None:
        cv2.imwrite(img_nome + ".png" , img)

#Exemplo 01 – Abrir uma imagem colorida, visualizar e salvar
def exe_01():
    img_titulo = 'EXE-01'
    img = selecionar_img()

    if img:
        img = cv2.imread(img)
        if img is not None:
            mostrar_img(img, img_titulo)
            salvar_img(img, img_titulo)

#Exemplo 02 – Abrir uma imagem colorida, transformar em níveis de cinza, visualizar e salvar
def exe_02():
    img_titulo = 'EXE_02'
    img = selecionar_img()

    if img:
        img = cv2.imread(img)
        img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
        if img is not None:
            mostrar_img(img, img_titulo)
            salvar_img(img, img_titulo)

#Exemplo 03 – Abrir uma imagem colorida em RGB, visualizar e salvar cada um dos canais separadamente. Obs: Busquem compreender o que significa cada um dos canais.
def exe_03():
    img_titulo = 'EXE_03'
    img = selecionar_img()

    if img:
        img = cv2.imread(img)
        #vai separar em canal de azul, verde e vermelho
        canais = cv2.split(img)
        if img is not None:
            for i, canal in enumerate(canais):
                titulo = f"{img_titulo}_{'azul' if i == 0 else ('verde' if i == 1 else 'vermelho')}"
                mostrar_img(canal, titulo)
                salvar_img(canal, titulo)

#Exemplo 04 – Abrir uma imagem colorida, transformar em tom de cinza, visualizar imagem de entrada. Apliquem os filtros passa baixa mediana (median) e media (blur)
def exe_04():
    img_titulo = 'EXE_04'
    img = selecionar_img()

    if img:
        img = cv2.imread(img)
        if img is not None:
            #para baixa mediana
            mediana = cv2.medianBlur(cv2.cvtColor(img, cv2.COLOR_BGR2GRAY), 3)
            mostrar_img(mediana, f'{img_titulo}_mediana')
            salvar_img(mediana, f'{img_titulo}_mediana')
            #para media
            media = cv2.blur(cv2.cvtColor(img, cv2.COLOR_BGR2GRAY), (3,3))
            mostrar_img(media, f'{img_titulo}_media')
            salvar_img(media, f'{img_titulo}_media')

#Exemplo 05 – Abrir uma imagem colorida, transformar em tom de cinza, visualizar imagem de entrada. Apliquem uma limiarização (thresholding),
#visualizem os resultados e salvem. Obs: busquem compreender os resultados da técnica
def exe_05():
    img_titulo = 'EXE_05'
    img = selecionar_img()

    if img:
        img = cv2.imread(img)
        if img is not None:
            img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
            #segundao parametro vc escolhe qual preferir, terceiro seria o max da cor do pixel
            limiar, imagem_limiarizada = cv2.threshold(img, 125, 255, cv2.THRESH_BINARY)
            mostrar_img(imagem_limiarizada, img_titulo)
            salvar_img(imagem_limiarizada, img_titulo)


if __name__ == "__main__":
    main()