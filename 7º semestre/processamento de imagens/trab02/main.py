import cv2
from exe_pi_luan import ExeProcImg
from exe_pi_maria import main as exe_maria
from trab_pi_mamografia import aprimoramento_contraste_morfologico, exibir_painel

class ChamadorClasses:
    def __init__(self):
        self.chamar_exe_luan()
        self.chamar_exe_maria()
        self.chamar_trab_mamografia()

    def chamar_exe_luan(self):
        ExeProcImg()

    def chamar_exe_maria(self):
        exe_maria()

    def chamar_trab_mamografia(self):
        imagem_mamografia = cv2.imread('imgs/img-mamografia.png', cv2.IMREAD_GRAYSCALE)
        imagem_aprimorada = aprimoramento_contraste_morfologico(imagem_mamografia)
        exibir_painel(imagem_mamografia, imagem_aprimorada)

# Instancia a classe e chama os métodos
ChamadorClasses()