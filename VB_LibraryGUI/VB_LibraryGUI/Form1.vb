Imports System
Imports System.IO


Public Class Form1

    Private Sub Button2_Click(sender As System.Object, e As System.EventArgs) Handles Button2.Click
        Me.Close()
    End Sub

    Private Sub Button1_Click(sender As System.Object, e As System.EventArgs) Handles Button1.Click
        search()
    End Sub

    Private Sub search()
        Dim exe As String = "java -jar Northshore_Library_Two.jar -s "
        exe = exe + TextBox1.Text
        IO.Directory.SetCurrentDirectory("P:\Northshore Time Sheet\Tools\LIBRARY\")
        Shell(exe)
    End Sub

    Private Sub TextBox1_KeyDown(sender As System.Object, e As System.Windows.Forms.KeyEventArgs) Handles TextBox1.KeyDown
        If e.KeyCode = Keys.Enter Then
            search()
        End If
    End Sub

    Private Sub LinkLabel1_LinkClicked(sender As System.Object, e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel1.LinkClicked
        Process.Start("P:\Northshore Time Sheet\Tools\LIBRARY\Help.html")
    End Sub

    Private Sub Form1_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load

        ComboBox1.SelectedIndex = 0
        getlength()
        'setList("CompiledTags.txt")

        TextBox1.Select()


    End Sub

    Private Sub getlength()
        Dim count As Integer
        Using sr As New StreamReader("P:\Northshore Time Sheet\Tools\LIBRARY\database.dat")
            Do While sr.Peek <> -1
                sr.ReadLine()
                count += 1
            Loop
        End Using

        lblLength.Text = "We currently have " & count - 2 & " Details in the database!"

    End Sub

    Private Sub setList(ByRef file)
        'clear out the listbox
        ListBox1.Items.Clear()

        'set the path to the ref file
        Dim path As String = "P:\Northshore Time Sheet\Tools\LIBRARY\" & file

        'read file and set listbox
        Using sr As New StreamReader(path)
            Dim line As String
            Do While sr.Peek <> -1
                ListBox1.Items.Add(sr.ReadLine())
            Loop
        End Using

    End Sub

    Private Sub ListBox1_DoubleClick(sender As System.Object, e As System.EventArgs) Handles ListBox1.DoubleClick
        If TextBox1.Text <> "" Then
            TextBox1.Text += ", " + ListBox1.SelectedItem
        Else
            TextBox1.Text = ListBox1.SelectedItem
        End If

    End Sub

    Private Sub ListBox1_MouseHover(sender As System.Object, e As System.EventArgs) Handles ListBox1.MouseHover
        ToolTip1.SetToolTip(Me.ListBox1, "Double click to add to list")
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        Dim filename As String = ""
        If ComboBox1.SelectedIndex = 0 Then
            setList("CompiledTags.txt")
            Return
        Else
            setList(ComboBox1.SelectedItem.ToString + ".txt")
        End If

    End Sub
End Class
