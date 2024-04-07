import cv2
from tkinter import Tk, filedialog

class ExeProcImg:

    def __init__(self):
        print('chamando exercicio 1')
        self.exe_01()
        print('chamando exercicio 2')
        self.exe_02()
        print('chamando exercicio 3')
        self.exe_03()
        print('chamando exercicio 4')
        self.exe_04()
        print('chamando exercicio 5')
        self.exe_05()


    # função para selecionar uma imagem
    def selecionar_img(self):
        root = Tk()
        root.withdraw()
        #abrir a janela de seleção na pasta de imagens
        path_img = filedialog.askopenfilename(defaultextension='.png')
        root.destroy()

        return path_img
    
    # função para exibir a imagem e esperar alguma tecla ser clicada
    def mostrar_img(self, img, img_titulo):
        if img is not None:
            cv2.imshow(img_titulo, img)
            cv2.waitKey(0)
            cv2.destroyAllWindows()
        else:
            print('Nenhuma imagem selecionada!')

    
    #função para salvar a imagem
    def salvar_img(self, img, img_nome):
        if img is not None:
            cv2.imwrite(img_nome + ".png" , img)
            print('imagem salva com sucesso!')
        else:
            print('Nenhuma imagem selecionada!')

    #Exemplo 01 – Abrir uma imagem colorida, visualizar e salvar
    def exe_01(self):
        img_titulo = 'EXE-01'
        img = self.selecionar_img()

        if img:
            img = cv2.imread(img)
            if img is not None:
                self.mostrar_img(img, img_titulo)
                self.salvar_img(img, img_titulo)
        else:
            print('nenhuma imagem selecionada')

    #Exemplo 02 – Abrir uma imagem colorida, transformar em níveis de cinza, visualizar e salvar 
    def exe_02(self):
        img_titulo = 'EXE_02'
        img = self.selecionar_img()

        if img:
            img = cv2.imread(img)
            img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
            if img is not None:
                self.mostrar_img(img, img_titulo)
                self.salvar_img(img, img_titulo)

    #Exemplo 03 – Abrir uma imagem colorida em RGB, visualizar e salvar cada um dos canais separadamente. Obs: Busquem compreender o que significa cada um dos canais.
    def exe_03(self):
        img_titulo = 'EXE_03'
        img = self.selecionar_img()

        if img:
            img = cv2.imread(img)
            #vai separar em canal de azul, verde e vermelho
            canais = cv2.split(img)
            if img is not None:
                for i, canal in enumerate(canais):
                    titulo = f"{img_titulo}_{'azul' if i == 0 else ('verde' if i == 1 else 'vermelho')}"
                    self.mostrar_img(canal, titulo)
                    self.salvar_img(canal, titulo)
                    print(f'canal {titulo} salvo com sucesso!')

    #Exemplo 04 – Abrir uma imagem colorida, transformar em tom de cinza, visualizar imagem de entrada. Apliquem os filtros passa baixa mediana (median) e media (blur), 
    #visualizem os resultados e salvem. Obs: busquem compreender os resultados de cada filtro                
    def exe_04(self):
        img_titulo = 'EXE_04'
        img = self.selecionar_img()

        if img:
            img = cv2.imread(img)
            if img is not None:
                #para baixa mediana
                mediana = cv2.medianBlur(cv2.cvtColor(img, cv2.COLOR_BGR2GRAY), 3)
                self.mostrar_img(mediana, f'{img_titulo}_mediana')
                self.salvar_img(mediana, f'{img_titulo}_mediana')
                #para media
                media = cv2.blur(cv2.cvtColor(img, cv2.COLOR_BGR2GRAY), (3,3))
                self.mostrar_img(media, f'{img_titulo}_media')
                self.salvar_img(media, f'{img_titulo}_media')

    #Exemplo 05 – Abrir uma imagem colorida, transformar em tom de cinza, visualizar imagem de entrada. Apliquem uma limiarização (thresholding), 
    #visualizem os resultados e salvem. Obs: busquem compreender os resultados da técnica
    def exe_05(self):
        img_titulo = 'EXE_05'
        img = self.selecionar_img()

        if img:
            img = cv2.imread(img)
            if img is not None:
                img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
                #segundao parametro vc escolhe qual preferir, terceiro seria o max da cor do pixel
                limiar, imagem_limiarizada = cv2.threshold(img, 125, 255, cv2.THRESH_BINARY)
                self.mostrar_img(imagem_limiarizada, img_titulo)
                self.salvar_img(imagem_limiarizada, img_titulo)

# Instanciando a classe e chamando os métodos
ExeProcImg()