Imports System
Imports System.IO


Public Class Form1

    Private Sub Button2_Click(sender As System.Object, e As System.EventArgs) Handles GlobalExitButton.Click
        Me.Close()
    End Sub

    Private Sub Button1_Click(sender As System.Object, e As System.EventArgs) Handles TextSearchButton.Click
        search()
    End Sub

    Private Sub search()
        Dim exe As String = "java -jar Northshore_Library_Two.jar -s "
        exe = exe + TextSearchBox.Text
        IO.Directory.SetCurrentDirectory("P:\Northshore Time Sheet\Tools\LIBRARY\")
        Shell(exe)
        'Button3.PerformClick()
    End Sub

    Private Sub TextBox1_KeyDown(sender As System.Object, e As System.Windows.Forms.KeyEventArgs) Handles TextSearchBox.KeyDown
        If e.KeyCode = Keys.Enter Then
            search()
        End If
    End Sub

    Private Sub LinkLabel1_LinkClicked(sender As System.Object, e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles TextSearchHelpLabel.LinkClicked
        Process.Start("P:\Northshore Time Sheet\Tools\LIBRARY\Help.html")
    End Sub

    Private Sub Form1_Load(sender As System.Object, e As System.EventArgs) Handles MyBase.Load

        AdvancedTagCatCombo.SelectedIndex = 0
        getlength()
        TextSearchBox.Select()

        'set the path to the ref file
        Dim path As String = "P:\Northshore Time Sheet\Tools\LIBRARY\" & "database.dat"

        'typical vars
        Dim linein As String
        Dim catin() As String

        'get job numbers
        '--------------------------------------------------------------------------
        'clear out the listbox
        JobNumberList.Items.Clear()

        'read file and set listbox
        Using sr As New StreamReader(path)
            linein = sr.ReadLine()
            linein = sr.ReadLine()
            Do While sr.Peek <> -1
                linein = sr.ReadLine()
                catin = Split(linein, "$")
                If Not JobNumberList.Items.Contains(catin(3)) Then
                    JobNumberList.Items.Add(catin(3))
                End If
            Loop
        End Using
        JobNumberList.Sorted = True

        'get job names
        '--------------------------------------------------------------------------
        'clear out the listbox
        JobNameList.Items.Clear()

        'read file and set listbox
        Using sr As New StreamReader(path)
            linein = sr.ReadLine()
            linein = sr.ReadLine()
            Do While sr.Peek <> -1
                linein = sr.ReadLine()
                catin = Split(linein, "$")
                If Not JobNameList.Items.Contains(catin(2)) Then
                    JobNameList.Items.Add(catin(2))
                End If
            Loop
        End Using
        JobNameList.Sorted = True

    End Sub

    Private Sub getlength()
        Dim count As Integer
        Using sr As New StreamReader("P:\Northshore Time Sheet\Tools\LIBRARY\database.dat")
            Do While sr.Peek <> -1
                sr.ReadLine()
                count += 1
            Loop
        End Using

        GlobalDatabaseSizeLabel.Text = "We currently have " & count - 2 & " Details in the database!"

    End Sub

    Private Sub setList(ByRef file)
        'clear out the listbox
        AdvancedTagList.Items.Clear()

        'set the path to the ref file
        Dim path As String = "P:\Northshore Time Sheet\Tools\LIBRARY\" & file

        'read file and set listbox
        Using sr As New StreamReader(path)
            Dim line As String
            Do While sr.Peek <> -1
                AdvancedTagList.Items.Add(sr.ReadLine())
            Loop
        End Using

    End Sub


    Private Sub ListBox1_MouseHover(sender As System.Object, e As System.EventArgs) Handles AdvancedTagList.MouseHover
        ToolTip1.SetToolTip(Me.AdvancedTagList, "Double click to add to list")
    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(sender As System.Object, e As System.EventArgs) Handles AdvancedTagCatCombo.SelectedIndexChanged
        Dim filename As String = ""
        If AdvancedTagCatCombo.SelectedIndex = 0 Then
            setList("CompiledTags.txt")
            Return
        Else
            setList(AdvancedTagCatCombo.SelectedItem.ToString + ".txt")
        End If

    End Sub


    Private Sub Button3_Click(sender As System.Object, e As System.EventArgs) Handles TextSearchClear.Click
        TextSearchBox.Text = ""
    End Sub


#Region "Advanced"
    Private Sub AdvancedTagAddButton_Click(sender As System.Object, e As System.EventArgs) Handles AdvancedTagAddButton.Click

        Try
            If Not AdvancedIncludeList.Items.Contains(AdvancedTagList.SelectedItem) Then
                AdvancedIncludeList.Items.Add(AdvancedTagList.SelectedItem)
            End If
        Catch ex As Exception

        End Try

    End Sub

    Private Sub AdvancedTagList_MouseDoubleClick(sender As System.Object, e As System.Windows.Forms.MouseEventArgs) Handles AdvancedTagList.MouseDoubleClick

        If Not AdvancedIncludeList.Items.Contains(AdvancedTagList.SelectedItem) Then
            AdvancedIncludeList.Items.Add(AdvancedTagList.SelectedItem)
        End If

    End Sub

    Private Sub AdvancedIncludeRemoveButton_Click(sender As System.Object, e As System.EventArgs) Handles AdvancedIncludeRemoveButton.Click

        Try
            AdvancedIncludeList.Items.Remove(AdvancedIncludeList.SelectedItem)
        Catch ex As Exception
        End Try

    End Sub

    Private Sub AdvancedIncludeList_DoubleClick(sender As System.Object, e As System.EventArgs) Handles AdvancedIncludeList.DoubleClick

        Try
            AdvancedIncludeList.Items.Remove(AdvancedIncludeList.SelectedItem)
        Catch ex As Exception
        End Try

    End Sub

    Private Sub AdvancedClearButton_Click(sender As System.Object, e As System.EventArgs) Handles AdvancedClearButton.Click
        AdvancedIncludeList.Items.Clear()
        AdvancedExcludeList.Items.Clear()
    End Sub

    Private Sub AdvancedSearchButton_Click(sender As System.Object, e As System.EventArgs) Handles AdvancedSearchButton.Click
        Dim exe As String = "java -jar Northshore_Library_Two.jar -s "
        Dim txt As String = ""

        For Each i As String In AdvancedIncludeList.Items
            If txt = "" Then
                txt = i
            Else
                txt = txt & "," & i
            End If
            'txt = txt & " " & i
        Next

        exe = exe + txt
        IO.Directory.SetCurrentDirectory("P:\Northshore Time Sheet\Tools\LIBRARY\")
        Shell(exe)
    End Sub

#End Region

    
    
    Private Sub JobNumberOpenButton_Click(sender As System.Object, e As System.EventArgs) Handles JobNumberOpenButton.Click
        If Not JobNumberList.SelectedIndex = -1 Then
            search(JobNumberList.SelectedItem)
        End If
    End Sub

    Private Sub search(ByRef term)
        Dim exe As String = "java -jar Northshore_Library_Two.jar -s "
        exe = exe + term
        IO.Directory.SetCurrentDirectory("P:\Northshore Time Sheet\Tools\LIBRARY\")
        Shell(exe)
    End Sub

    Private Sub JobNameOpenButton_Click(sender As System.Object, e As System.EventArgs) Handles JobNameOpenButton.Click
        If Not JobNumberList.SelectedIndex = -1 Then
            search(JobNameList.SelectedItem)
        End If
    End Sub
End Class
