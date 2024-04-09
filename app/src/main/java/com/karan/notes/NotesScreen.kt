package com.karan.notes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Notes(notes: List<Note>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier, contentPadding = WindowInsets.statusBars.asPaddingValues()) {
        item {
            Text(
                text = "Notes",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(12.dp)
            )
        }

        items(notes) { note ->
            NoteItem(note = note)
        }
    }
}

@Composable
private fun NoteItem(note: Note, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(12.dp)) {
        Text(
            text = note.title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = note.text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = note.date,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Preview
@Composable
fun PreviewNotes() {
    Notes(notes = notes)
}
