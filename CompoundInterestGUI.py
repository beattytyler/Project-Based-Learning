from tkinter import *
from tkinter import ttk

root = Tk()
root.title("Compound Interest Calculator")

def calculate():
    try:
        P_value = float(P.get())
        r_value = float(r.get())
        n_value = float(n.get())
        t_value = float(t.get())
        calculated_total = P * ((1+((r * 0.01)/n)) ** (n * t))
        A.set(calculated_total)
    except:
        pass

mainframe = ttk.Frame(root, padding = "3, 3, 12, 12")
mainframe.grid(column = 0, row = 0, sticky = (N, W, E, S))
root.columnconfigure(0, weight = 1)
root.rowconfigure(0, weight = 1)

P = stringVar()
P.entry = ttk.Entry(mainframe, width = 5, textvariable = P)