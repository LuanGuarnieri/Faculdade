import numpy as np
import cv2
"""
alunos: Luan L. Guarnieri - Maria E. Krutzsch
"""
# Carrega a imagem e coloca em tons de cinza (pq se não vai carregar em tridimensional - RGB)
imagem_mamografia = cv2.imread('imgs/img-mamografia.png', cv2.IMREAD_GRAYSCALE)

def aprimoramento_contraste_morfologico(imagem):
    # Cria o kernel - matriz 5x5 para definir o tamanho da vizinhança
    kernel = np.ones((5,5), np.uint8)
    abertura = cv2.morphologyEx(imagem, cv2.MORPH_OPEN, kernel)
    fechamento = cv2.morphologyEx(imagem, cv2.MORPH_CLOSE, kernel)

    return np.abs(abertura.astype(np.int32) - fechamento.astype(np.int32)).astype(np.uint8)

# Cria um painel e coloca a img original e a aprimorada lado a lado
def exibir_painel(imagem_original, imagem_aprimorada):
    painel = np.hstack((imagem_original, imagem_aprimorada))
    cv2.imshow('Imagens', painel)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

# Chama as funções criadas
imagem_aprimorada = aprimoramento_contraste_morfologico(imagem_mamografia)
exibir_painel(imagem_mamografia, imagem_aprimorada)