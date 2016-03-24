using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using System.Diagnostics;

namespace TimeSnap
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            runtime process = new runtime();
            if (process.IsProcessOpen("TimeSnap") == false)
            {
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                Application.Run(new TimeSnap());
            }
            else
            {
                MessageBox.Show("Process is already running");
            }
        }
        
        class runtime
        {
            public bool IsProcessOpen(string name)
            {
                int i = 0;
                foreach (Process clsProcess in Process.GetProcesses())
                {
                    if (clsProcess.ProcessName.Equals(name))
                    {
                        i++;
                    }
                }
                if (i <= 1) { return false; }
                else { return true; }
            }
        }
    }
}
