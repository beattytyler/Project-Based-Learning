from tkinter import *
from tkinter import ttk

root = Tk()
root.title("BMI Calculator")

def calculate():
    try:
        hValue = float(height.get())
        wValue = float(weight.get())
        calculated_bmi = round(float(wValue / (hValue ** 2)) * 703, 1)
        bmi.set(calculated_bmi)

        if calculated_bmi < 19:
             classification.set("You are underweight")
        elif 19 < calculated_bmi < 24:
             classification.set("You are healthy")
    except:
        pass

mainframe = ttk.Frame(root, padding = "3 3 12 12")
mainframe.grid(column = 0, row = 0, sticky = (N, W, E, S))
root.columnconfigure(0, weight = 1)
root.rowconfigure(0, weight = 1)

height = StringVar()
height_entry = ttk.Entry(mainframe, width = 7, textvariable = height)
height_entry.grid(column = 1, row = 1, sticky = (W, E))

weight = StringVar()
weight_entry = ttk.Entry(mainframe, width = 7, textvariable = weight)
weight_entry.grid(column = 3, row = 1, sticky = (W, E))

bmi = StringVar()
ttk.Label(mainframe, textvariable = bmi).grid(column = 2, row = 2, sticky = (W, E))

classification = StringVar()
ttk.Label(mainframe, textvariable = classification).grid(column = 3, row = 2, sticky = (W, E))

ttk.Button(mainframe, text = "Calculate BMI", command = calculate). grid(column = 2, row = 3, sticky = W)

ttk.Label(mainframe, text = "inches and").grid(column = 2, row = 1, sticky = W)
ttk.Label(mainframe, text = "pounds").grid(column = 4, row = 1, sticky = W)
ttk.Label(mainframe, text = "equates to a bmi of").grid(column = 1, row = 2, sticky = E)


for child in mainframe.winfo_children():
    child.grid_configure(padx = 5, pady = 5)

weight_entry.focus()
height_entry.focus()

root.bind("<Return>", calculate)

root.mainloop()